class Solution {
    /**
     * 分治合并的排序思想
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        // 特判
        if (lists.length < 1)
            return null;
        if (lists.length == 1)
            return lists[0];

        int len = lists.length;
        return merge(lists, 0, len-1);
    }

    /**
     * 归并排序思想
     * @param lists
     * @param left
     * @param right
     * @return
     */
    public ListNode merge(ListNode[] lists, int left, int right){
        if (left == right)
            return lists[left];
        int mid = left + (right - left) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid+1, right);
        return mergeTwoLists(l1, l2);  // 直接利用之前做过的题-（合并两个有序链表）
    }

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

class Solution2 {
    /**
     * 引入内置的优先队列数据结构进行优化
     * 优先队列需附加“小顶堆”功能
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        // 特判
        if (len < 1)
            return null;
        if (len == 1)
            return lists[0];

//        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(len, Comparator.comparingInt(o -> o.val));
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((x,y)->x.val-y.val);  // lambda表达式提供小顶堆功能
        for (ListNode head: lists){
            if (head != null)
                minHeap.add(head);
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode curNode = dummyNode;
        while (minHeap.size() > 1){
            ListNode top = minHeap.poll();
            curNode.next = top;

            curNode = curNode.next;
            if (top.next != null){
                minHeap.add(top.next);
            }
        }
        curNode.next = minHeap.poll();
        return dummyNode.next;

    }
}