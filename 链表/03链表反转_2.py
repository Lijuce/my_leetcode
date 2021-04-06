# LeetCode题号92-反转链表2(连续区间部分链表反转)
# python实现链表反转-连续区间部分链表反转
from BaseLink import *

class SingleLinkList(Link):
    def reverseBetween_PreN(self, head, N, mode="recu"):
        # 递归方式实现反转链表前N个节点
        # head = self.head
        def Between(head: Node, right: int):
            if right == 1:
                global successor  # 全局变量声明，否则successor无法直接调用
                successor = head.next
                return head
            last = Between(head.next, right-1)
            head.next.next = head
            head.next = successor  

            return last
        tmp_node = Between(head, N)

        print("链表前N个节点反转完成")
        return tmp_node

    def reverseBetween(self, head, left, right):
        # 递归方式实现反转链表指定区间内[m, n]节点
        if left == 1:  # base case
            tmp_node = self.reverseBetween_PreN(head=head, N=right)  # 当left=1时，相当于反转前N个元素
            return tmp_node

        last = self.reverseBetween(head.next, left-1, right-1)
        head.next = last
        print("链表区间个节点反转完成")
        return head

    def reverse(self, start: Node, obj: Node) -> Node:
        # 迭代方式实现链表整体反转
        cur = start
        nxt = obj
        pre = None
        while cur != obj:  # 1 -> 2 -> 3
            nxt = cur.next
            cur.next = pre
            pre = cur
            cur = nxt
        head = pre
        return head

    def reverseKGroup(self, head: Node, K: int) -> Node:
        # 链表中K元素一组进行反转
        if head is None:
            return None

        start = head
        obj = head

        for i in range(K):
            # 从头开始计目标节点所在位置
            if obj is None:
                return head  # base case: 当不足K个，无需反转

            obj = obj.next

        new_head = self.reverse(start, obj)

        tmp_node = self.reverseKGroup(obj, K)
        start.next = tmp_node  # 将前面组和下一组进行连接

        return new_head


SingleLink = SingleLinkList()
link = SingleLink.construct([1,2,3,4,5,6,7])  # 链表初始化
# link = SingleLink.reverseBetween_PreN(head=link, N=3, mode='recu')
# link = SingleLink.reverseBetween(link, left=2, right=4)
# SingleLink.travel(link)
link = SingleLink.reverseKGroup(link, 3)
# a = link.next
# b = a.next.next
# link = SingleLink.reverse(a, b)
SingleLink.printLink(link)
