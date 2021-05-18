class Solution{
    /**
     * 328. 奇偶链表
     * 双指针
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        // 特判
        if (head == null || head.next == null || head.next.next == null)
            return head;
        ListNode head1 = new ListNode(-1);
        ListNode head2 = new ListNode(-1);
        ListNode head2Dummy = head2;
        ListNode head1Dummy = head1;

        while (head.next != null && head.next.next != null){
            head1.next = head;
            head1 = head1.next;

            head2.next = head.next;
            head2 = head2.next;

            head = head.next.next;
        }
        if (head.next == null){
            // 说明剩最后一个奇数节点
            head1.next = head;
        }else {
            // 说明剩两个节点
            head1.next = head;
            head2.next = head.next;
            head2 = head2.next;
        }
        head1 = head1.next;
        head1.next = head2Dummy.next; // 将两个表拼接
        head2.next = null;  // 偶数表最后指向NULL，否则会形成循环链表
        return head1Dummy.next;
    }
}