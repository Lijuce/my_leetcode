# 2021年4月6日
# 力扣热门100题之一
# 23. 合并K个升序链表(困难题-----还需多加理解)


def mergeKLists(lists):
    # 普通循环迭代
    # def mergeTwoLists(l1, l2):
    #     head1 = l1
    #     head2 = l2
    #     head = ListNode()
    #     res = head

    #     while head1 and head2:
    #         if head1.val < head2.val:
    #             head.next = head1
    #             head1 = head1.next
    #         else:
    #             head.next = head2
    #             head2 = head2.next
    #         head = head.next

    #     head.next = head1 if head1 else head2
    #     return res.next
    
    # if len(lists) < 1:
    #     return None
    # if len(lists) == 1:
    #     return lists[00]

    # res = ListNode()
    # head = lists[0]
    # for li in lists[1:]:
    #     res.next = mergeTwoLists(head, li)
    #     head = res.next
    # return res.next

    # 优化：分治思想-归并排序（构建小顶堆）
    if not lists:return 
    n = len(lists)
    return merge(lists, 0, n-1)
def merge(lists, left, right):
    if left == right:
        return lists[left]
    mid = left + (right - left) // 2
    l1 = merge(lists, left, mid)
    l2 = merge(lists, mid+1, right)
    return mergeTwoLists(l1, l2)  # 
def mergeTwoLists(l1, l2):
    if not l1:return l2
    if not l2:return l1
    if l1.val < l2.val:  # 小值优先归并
        l1.next = mergeTwoLists(l1.next, l2)
        return l1
    else:
        l2.next = mergeTwoLists(l1, l2.next)
        return l2


    # 利用Python内置模块heapq
    # if not lists:
    #     return None
    # dummy = ListNode()
    # heap = []
    # for i in range(len(lists)):
    #     if lists[i]:
    #         heapq.heappush(heap, (lists[i].val, i))  # 往堆中插入一条新的值
    #         lists[i] = lists[i].next
    # cur = dummy
    # while heap:
    #     val, idx = heapq.heappop(heap)  # 从堆中弹出最小值（内部自动计算）
    #     cur.next = ListNode(val)
    #     cur = cur.next
    #     if lists[idx]:
    #         heapq.heappush(heap, (lists[idx].val, idx))
    #         lists[idx] = lists[idx].next
    # return dummy.next