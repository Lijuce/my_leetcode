class Solution{
    /**
     * 203. 移除链表元素
     * 穿针引线的迭代法
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {

        // 特判
        if (head == null)
            return head;
        ListNode dummyNode;
        ListNode newNode = new ListNode(-1);
        dummyNode = newNode;
        while (head != null) {
            if (head.val != val) {
                newNode.next = head;
                newNode = newNode.next;
            }
            head = head.next;
        }
        newNode.next = null;

        return dummyNode.next;
    }

    /**
     * 递归法
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {

        // 特判
        if (head == null)
            return head;

        head.next = removeElements(head.next, val);
        if (head.val == val){
            return head.next;
        }else {
            return head;
        }

    }

}