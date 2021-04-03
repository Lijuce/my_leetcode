# 141. 环形链表
# 检测链表是否含有环形

def hasCycle(head: ListNode) -> bool:
    slow = head
    high = head

    while high is not None and high.next is not None:
        slow = slow.next
        high = high.next.next
        if high == slow:
            return True
    
    return False