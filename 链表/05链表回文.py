# LeetCode题号234-回文链表检测

# 热身题 题号9-回文数  
def isPalindrome(x: int) -> bool:
    # if x < 0 or (x/100==0 and x%10>0) :
    #     return False
    # # tmp = x % 10
    # str_x = str(x)
    # length = len(str_x)
    # left = 0
    # right = length-1
    # while left <= right:
    #     if str_x[left] != str_x[right]:
    #         return False
    #     left += 1
    #     right -= 1

    # return True

    # 进阶：不以字符串思路进行判断
    if x < 0 or (x!=0 and x%10==0):
        return False
    # 132231 123322
    num = 0
    while num < x:
        a = x % 10
        x = x // 10  # // 整除
        
        num = num*10 + a

    return num == x or num//10==x

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

    def traverse(self, right: Node) -> bool:
        # 利用 栈 做后序遍历 
        # 算法的时间和空间复杂度都是 O(N)
        if right is None:
            return True
        bool_right = self.traverse(right.next)
        bool_right = (bool_right and self.left.data == right.data)

        self.left = self.left.next  # 继续下一个比较
        return bool_right

    def advanced_traverse(self, head: Node) -> bool:
        # 优化后 空间复杂度 O(1)
        def simple_traverse(head: Node):  # 此处反转链表不使用 栈
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

        slow = fast = head
        while fast is not None and fast.next is not None:  # 利用快慢指针寻找链表中间点
            fast = fast.next.next
            slow = slow.next
        if fast is not None:  # 如果fast指针没有指向None，说明链表长度为奇数，slow还要再前进一步
            slow = slow.next  # 已找到中间点，并将其作为后半部分的头结点
        traversed_right = simple_traverse(slow)  # 反转链表后半部分
        left = head
        # 判断是否相等
        while traversed_right is not None:
            # if left.data == traversed_right.data:
            #     left = left.next
            #     traversed_right = traversed_right.next
            # else:
            #     return False
            if left.data != traversed_right.data:
                return False
            left = left.next
            traversed_right = traversed_right.next

        return True


        
    
    def isPalindrome(self, head: Node) -> bool:
        self.left = head
        return self.advanced_traverse(head)

SingleLink = SingleLinkList()
link = SingleLink.construct([1,2,2,1])  # 链表初始化
SingleLink.travel(link)
print(SingleLink.isPalindrome(link))
SingleLink.travel(link)
