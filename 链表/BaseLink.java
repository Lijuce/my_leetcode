package com.company;

public class LinkUtils {
//    static LinkNode head = null;

    /**
     * 构建单链表
     * @param data
     */
    public static LinkNode constructLink(Integer[] data){
        LinkNode head = null;
        LinkNode p = null;
        head = new LinkNode(data[0]);
        p = head;
        for (int i = 1; i < data.length; i++){
            LinkNode tempNode = new LinkNode(data[i]);
            p.next = tempNode;
            p = p.next;
        }
        p.next = null;
        return head;
    }

    /**
     * 输出单链表
     */
    public static void PrintLink(LinkNode head){
        LinkNode cur = null;
        cur = head;
        System.out.print("单链表输出：");
        while (cur != null){
            System.out.print(cur.val);
            System.out.print(" ");
            cur = cur.next;
        }
        System.out.println();
    }

    /**
     * 链表新元素添加，尾部插入法
     * @param val
     */
    public static void addTail(LinkNode head, Integer val){
        LinkNode linkNode = new LinkNode(val);
        LinkNode cur = head;
        while (cur.next != null){
            cur = cur.next;
        }
        cur.next = linkNode;
        linkNode.next = null;
        System.out.println("尾部成功添加新元素！");
    }

//    public static void addHead(LinkNode head, Integer val){
//        LinkNode linkNode = new LinkNode(val);
//        linkNode.next = head;
//        head = linkNode;
//        System.out.println("头部成功添加新元素！");
//    }

    /**
     * 搜索某节点
     * @param head
     * @param val
     * @return 节点索引
     */
    public static Integer searchLinkData(LinkNode head, Integer val){
        LinkNode cur = head;
        int index = 1;  // 节点索引
        while (cur != null){
            if (cur.val.equals(val)){
                return index;
            }else {
                cur = cur.next;
                index ++;
            }
        }
        System.out.println("不存在此节点");
        return -1;
    }
    
    /**
     * 按索引修改节点
     * @param head
     * @param index
     * @param target
     */
    public static void modifyLinkData(LinkNode head, Integer index, Integer target){
        LinkNode cur = head;
        Integer searchIndex = 1;
        while (cur != null){
            if (searchIndex.equals(index)){
                cur.val = target;
                System.out.println("成功修改相应节点");
                return;
            }else {
                cur = cur.next;
                searchIndex ++;
            }
        }
        System.out.println("不存在此节点，修改失败");
        return;
    }

    /**
     * 按值删除链表节点
     * @param head
     * @param target
     */
    public static void removeLinkData(LinkNode head, Integer target){
        LinkNode cur = head;
        LinkNode prev = null;
        while (cur != null){
            if (cur.val.equals(target)){
                prev.next = cur.next;
                cur.next = null;
                System.out.println("成功删除节点");
                return;
            }else {
                prev = cur;
                cur = cur.next;
            }
        }
        System.out.println("无此节点");
    }
}

class LinkNode {
    Integer val;
    LinkNode next;
    LinkNode(Integer val){
        this.val = val;
    }
}
