public class Solution {
    /**
     * 160. 相交链表
     * "巧妙"法: 2个指针同时遍历相同长度的连表，当两个值地址相等时，就是相交节点，因为相交节点必定在链表尾部
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode head1 = headA;
        ListNode head2 = headB;

        while (head1 != head2){  // 没有相交点时，最终一定会有 null == null 的判断
            if (head1 != null){
                head1 = head1.next;
            }else {
                head1 = headB;
            }
            if (head2 != null){
                head2 = head2.next;
            }else {
                head2 = headA;
            }
        }
        return head1;
    }
}