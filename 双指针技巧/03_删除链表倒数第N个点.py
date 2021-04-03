# 19. 删除链表的倒数第 N 个结点

def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
    if head.next is None:
        return None

    slow = fast = head
    while n:
        n -= 1
        fast = fast.next

    #  如果此时快指针走到头了，
    #  说明倒数第 n 个节点就是第一个节点
    if fast is None:
        return head.next          

    # prev = ListNode()
    # while fast is not None:
    #     if fast.next is None:  # 保存所删节点的前驱
    #         prev = slow
    #     slow = slow.next
    #     fast = fast.next
                
    # prev.next = slow.next
    # slow.next = None
    
    # 简洁版
    while fast is not None and fast.next is not None:
        fast = fast.next
        slow = slow.next

    slow.next = slow.next.next

    return head