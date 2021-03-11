# LeetCode题号206-反转链表
# python实现链表反转

class Node:
    def __init__(self, val=0, next=None):
        self.data = val
        self.next = next

class SingleLinkList(object):
    def __init__(self):
        self.head = 0  # 头结点
    
    def construct(self, datas: list):
        # 单链表创建
        self.head = Node(datas[0])
        p = self.head
        for number in datas[1:]:
            new_node = Node(number)
            p.next = new_node
            p = p.next
        p.next = None  # 尾部结点指向None

    def travel(self):
        # 链表遍历
        cur = self.head
        while cur is not None:
            print(cur.data)
            cur = cur.next
        # print(cur.data)  # 尾结点的值
        print("遍历完成！")

    def reverseList(self, mode="iter"):
        if mode == "iter":
        # 迭代方式实现反转
            cur = self.head
            pre = None
            while cur is not None:
                back = cur.next
                cur.next = pre
                pre = cur
                cur = back
            self.head = pre
            return 
        elif mode == 'recu':
        # 递归方式实现反转
            head = self.head
            def recu(head: Node):
                if head.next is None:
                    return head
                last = recu(head.next)
                head.next.next = head
                head.next = None

                return last
            tmp_node = recu(head)
            self.head = tmp_node

        else:
            raise ValueError("Sorry, the mode do not exit, please choose reasonable mode again.")

        print("反转完成")

    # def reverseList_recu(self):
    #     head = self.head
    #     def recu(head: Node):
    #         if head.next is None:
    #             return head
    #         last = recu(head.next)
    #         head.next.next = head
    #         head.next = None

    #         return last

    #     tmp_node = recu(head)
    #     self.head = tmp_node


SingleLink = SingleLinkList()
SingleLink.construct([1,2,3,4])  # 链表初始化
SingleLink.travel()
SingleLink.reverseList(mode='recu')
# SingleLink.reverseList_recu()
SingleLink.travel()

