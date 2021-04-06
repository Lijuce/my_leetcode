# LeetCode题号25-K个一组翻转链表

from BaseLink import *

class SingleLinkList(Link):
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
# a = link.next
# b = a.next.next
# link = SingleLink.reverse(a, b)
link = SingleLink.reverseKGroup(link, 3)
SingleLink.printLink(link)
