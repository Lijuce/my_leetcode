# 2021年4月5日
# 力扣热门100题之一
# 2. 链表两数相加

def addTwoNumbers(l1, l2):
    head1 = l1
    head2 = l2
    res = ListNode()  # 存储 两数之和 的新链表
    head = res
    yushu = 0

    while head1 or head2:
        sum_val = 0
        if head1:
            sum_val += head1.val
            head1 = head1.next
        if head2:
            sum_val += head2.val
            head2 = head2.next
        if yushu:
            sum_val += yushu
            yushu = 0
        yushu, sum_val = divmod(sum_val, 10)
        head.next = ListNode(sum_val % 10)
        head = head.next
    if yushu == 1:
        head.next = ListNode(yushu)
    return res.next

    # 以上为以下代码的优化（非性能优化，是代码简洁优化）
    # while head1 and head2:
    #     sum_val = head1.val + head2.val + yushu
    #     head.next = ListNode(sum_val%10)
    #     head = head.next
    #     if sum_val >= 10:
    #         yushu = 1
    #     else:
    #         yushu = 0
    #     head1 = head1.next
    #     head2 = head2.next

    # while head1:
    #     sum_val = head1.val + yushu
    #     if sum_val >= 10:
    #         yushu = 1
    #     else:
    #         yushu = 0
    #     head.next = ListNode(sum_val%10)
    #     head = head.next
    #     head1 = head1.next

    # while head2:
    #     sum_val = head2.val + yushu
    #     if sum_val >= 10:
    #         yushu = 1
    #     else:
    #         yushu = 0
    #     head.next = ListNode(sum_val%10)
    #     head = head.next
    #     head2 = head2.next

    # if yushu == 1:
    #     head.next = ListNode(yushu)

    # return res.next
