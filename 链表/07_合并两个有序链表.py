# 2021年4月5日
# 力扣热门100题之一
# 21. 合并两个有序链表

from BaseLink import *

class SingleLinkList(Link):

    def mergeTwoLists(self, l1, l2):
        head1 = l1
        head2 = l2
        head = ListNode()
        res = head

        while head1 and head2:
            if head1.data < head2.data:
                head.next = head1
                head1 = head1.next
            else:
                head.next = head2
                head2 = head2.next
            head = head.next

        head.next = head1 if head1 else head2
        return res.next

SingleLink = SingleLinkList()
link1 = SingleLink.construct([1,2,4]) 
link2 = SingleLink.construct([1,3,4]) 
res = SingleLink.mergeTwoLists(link1, link2)
SingleLink.printLink(res)


