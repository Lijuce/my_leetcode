class Solution {
    /**
     * 24. 两两交换链表中的节点
     * 穿针引线的迭代法
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        // 特判
        if (head == null || head.next == null)
            return head;

        // 用dummyNode记住头节点
        ListNode dummyNode = new ListNode(-1);
        ListNode curNode = dummyNode;
        dummyNode.next = head;

        ListNode p1 = null;
        ListNode p2 = null;
        while (curNode.next !=null && curNode.next.next != null){
            p1 = curNode.next;
            p2 = p1.next;

            // 采用经典的穿针引线法，3步
            p1.next = p2.next;
            p2.next = p1;
            curNode.next = p2;

            // 循环遍历更新
            curNode = p1;
        }
    }
}

class Solution2 {
    /**
     * 24. 两两交换链表中的节点
     * 递归法
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return  head;

        ListNode p1 = head;
        ListNode p2 = head.next;

        p1.next = swapPairs(p2.next);
        p2.next = p1;
        return p2;
    }
}