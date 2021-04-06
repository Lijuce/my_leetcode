# 2021年4月5日
# 力扣热门100题之一
# 160. 相交链表

def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
    # # python的集合法 set
    # di = set()
    # while headA:
    #     di.add(headA)
    #     headA = headA.next
    # while headB:
    #     if headB in di:
    #         return headB
    #     headB = headB.next
    # return None

    # "巧妙"法:
    # 2个指针同时遍历相同长度的连表，当两个值地址相等时，就是相交节点，因为相交节点必定在链表尾部
    curr1, curr2 = headA, headB
    while curr1 != curr2:
        curr1 = curr1.next if curr1 else headB
        curr2 = curr2.next if curr2 else headA

    return curr1
