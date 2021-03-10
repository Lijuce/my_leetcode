# LeetCode题号25-K个一组翻转链表

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
        return self.head

    def travel(self, head):
        # 链表遍历
        cur = head
        while cur is not None:
            print(cur.data)
            cur = cur.next
        # print(cur.data)  # 尾结点的值
        print("遍历完成！")

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
SingleLink.travel(link)
