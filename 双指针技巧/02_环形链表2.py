# 142. 环形链表 II


def detectCycle(head):
    # 主要涉及简单的数学推导，如下(其中a为头结点到环起始点的距离，b为俩指针相遇时慢指针所经过的距离，c为环的剩余距离)
    # slow*2 = fast
    # slow = a+b
    # fast = a+b+c+b 代入1式
    # => a = c
    slow = head
    fast = head

    while fast is not None and fast.next is not None:
        slow = slow.next
        fast = fast.next.next
    
        if slow == fast:
            break
    
    if fast is None or fast.next is None:
        return None
    
    slow = head
    while slow != fast:
        fast = fast.next
        slow = slow.next
    
    return slow