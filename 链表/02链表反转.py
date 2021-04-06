# LeetCode题号206-反转链表
# python实现链表反转
from BaseLink import *

# class Node:
#     def __init__(self, val=0, next=None):
#         self.data = val
#         self.next = next

class SingleLinkList(Link):
    def reverseList(self, head, mode="iter"):
        if mode == "iter":
        # 迭代方式实现反转
            cur = head
            pre = None
            while cur is not None:
                back = cur.next
                cur.next = pre
                pre = cur
                cur = back
            head = pre
            return head

        elif mode == 'recu':
        # 递归方式实现反转
            # head = head
            def recu(head):
                if head.next is None:
                    return head
                last = recu(head.next)
                head.next.next = head
                head.next = None

                return last
            tmp_node = recu(head)
            head = tmp_node
            return head

        else:
            raise ValueError("Sorry, the mode do not exit, please choose reasonable mode again.")
        print("反转完成")


n = 5  # 例子长度
case_data = [random.randint(0,10) for i in range(n)]  # 测试例子随机生成
SingleLink = SingleLinkList()
head = SingleLink.construct(case_data)  # 链表初始化
head = SingleLink.reverseList(head, mode='recu')  # 测试函数
SingleLink.printLink(head)
