class Solution {
    /**
     * 83. 删除排序链表中的重复元素 I
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        // 特判
        if (head == null || head.next == null){
            return head;
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode curNode  = head;
        while (curNode.next != null){
            if (curNode.val == curNode.next.val){
                curNode.next = curNode.next.next;
            }else {
                curNode = curNode.next;
            }
        }
        return dummyNode.next;
    }
}