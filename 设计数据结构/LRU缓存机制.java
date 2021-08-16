package com.company;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class DLinkNode{
        int key;
        int value;
        DLinkNode prev;
        DLinkNode next;
        DLinkNode(){}
        DLinkNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, DLinkNode> cache = new HashMap<Integer, DLinkNode>();
    private int size;  // 当前容量使用情况
    private int capacity;  // 拟定容量大小
    private DLinkNode head, tail; // 伪头、尾节点

    /**
     *  LRUCache
     *  构造函数初始化
     */
    public LRUCache(int capacity){
        this.capacity = capacity;
        head = new DLinkNode();  // 伪头节点
        tail = new DLinkNode();  // 伪尾节点
        head.next = tail;
        tail.prev = head;
    }

    /**
     * 根据key返回缓存中对应的值
     * @param key
     * @return
     */
    public int get(int key){
        DLinkNode node = cache.get(key);
        if (node != null){
            // key存在，通过哈希表定位后移至头部
            moveToHead(node);
            return node.value;
        }else {
            return -1;
        }

    }

    public void put(int key, int value){
        DLinkNode node = cache.get(key);
        if (node != null){  // 当缓存中已存在key，改变值
            node.value = value;
            moveToHead(node);
        }else {
            // 不存在，则加入新节点
            DLinkNode newNode = new DLinkNode(key, value);
            cache.put(key, newNode);
            addNewNode(newNode);
            if ( this.size > this.capacity ){
                // 超出缓存大小，移除最后一个节点
                DLinkNode removeNode = removeTail();
                cache.remove(removeNode.key);
                this.size --;
            }
        }
    }

    private void addNewNode(DLinkNode node){
        addToHead(node);
        this.size ++;
    }

    private void moveToHead(DLinkNode node){
        // 先把该节点移除出来
        removeNode(node);
        // 再将该节点添加至头部
        addToHead(node);
    }

    private void removeNode(DLinkNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(DLinkNode node){
        DLinkNode tempNode = head.next;
        head.next = node;
        node.prev = head;
        node.next = tempNode;
        tempNode.prev = node;

    }

    private DLinkNode removeTail(){
        DLinkNode node = tail.prev;
        removeNode(node);
        return node;
    }

}
