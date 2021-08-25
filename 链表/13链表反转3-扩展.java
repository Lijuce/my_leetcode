class Solution {
    /**
     * K个一组进行链表反转，余下不足k个也得反转
     * 法一：递归法
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return head;
        ListNode start = head;
        ListNode end = head;
        // 先找到要翻转的那部分
        for (int i = 0; i < k; i++) {
            // 余下不足k个，不过也进行反转
            // 直接break，照常进行反转即可
            if (end == null) {
                break;
            }
            end = end.next;
        }

        // 翻转指定部分
        ListNode last = reverseSingleLinkIter(start, end);
        // 递归继续K组翻转
        start.next = reverseKGroup(end, k);
        return last;
    }
    /**
     * 迭代反转整体单链表
     * @param start
     * @param end
     * @return
     */
    public ListNode reverseSingleLinkIter(ListNode start, ListNode end){
        ListNode cur = start;
        ListNode successor = null;
        ListNode prev = null;
        while (cur != end){
            successor = cur.next;
            cur.next = prev;
            prev = cur;
            cur = successor;
        }
        return prev;
    }
}
