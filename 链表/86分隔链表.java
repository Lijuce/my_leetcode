class Solution {
    /**
     * 86. 分隔链表
     * 两个新链表分别分割节点，后合并
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode newNode = dummyNode;
        ListNode curNode = head;
        ListNode prevNode;
        ListNode dummyNode1 = new ListNode(-1);
        ListNode dummyNode2 = new ListNode(-1);
        ListNode head1 = dummyNode1;
        ListNode head2 = dummyNode2;

        while (curNode != null){
            if (curNode.val < x){
                head1.next = curNode;
                head1 = head1.next;
            }else {
                head2.next = curNode;
                head2 = head2.next;
            }
            curNode = curNode.next;
        }
        head1.next = dummyNode2.next;
        head2.next = null;
        return dummyNode1.next;
    }
}