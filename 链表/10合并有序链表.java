class Solution {
    /**
     * 21. 合并两个有序链表
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode dummyNode = new ListNode(-1);
        ListNode curNode = dummyNode;
        while (head1 != null && head2 != null){
            if (head1.val < head2.val){
                curNode.next = head1;
                head1 = head1.next;
            }else {
                curNode.next = head2;
                head2 = head2.next;
            }
            curNode = curNode.next;
        }
        if (head1 != null)
            curNode.next = head1;
        else
            curNode.next = head2;
        return dummyNode.next;
    }
}