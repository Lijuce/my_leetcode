class Solution {
    /**
     * 61. 旋转链表
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        // 特判
        if (head == null || head.next == null || k == 0)
            return head;

        int n = 1; // 记录链表长度
        ListNode fastNode = head;
        while (fastNode.next != null){
            fastNode = fastNode.next;
            n ++;
        }

        k = k % n;
        if (k == 0)  // 说明刚好饶了一个圈
            return head;

        ListNode slowNode = head;
        for (int i = 0; i < n - k - 1; i++) {
            slowNode = slowNode.next;  // 找到环的断点位置
        }

        // 穿针引线
        ListNode newHead = slowNode.next;  // 记录
        fastNode.next = head;
        slowNode.next = null;
        return newHead;

    }
}