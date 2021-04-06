# base of Link
import random

class Node:
    def __init__(self, val=0, next=None):
        self.data = val
        self.next = next

class Link(object):
    def __init__(self):
        pass

    def construct(self, datas: list):
        # 单链表创建-尾插法
        print("链表初始化：", end='')
        head = Node(datas[0])
        print(datas[0], end=' ')
        p = head
        for number in datas[1:]:
            print(number, end=' ')
            new_node = Node(number)
            p.next = new_node
            p = p.next
        print()
        p.next = None  # 尾部结点指向None
        
        return head
    
    def printLink(self, head):
        # 链表遍历
        cur = head
        print("链表输出：", end='')
        while cur is not None:
            print(cur.data, end=' ')
            cur = cur.next
        print("")
        