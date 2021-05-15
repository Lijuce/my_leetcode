class Solution {

    /**
     * 82. 删除排序链表中的重复元素 II
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
//        // 特判
//        if (head == null || head.next == null)
//            return head;
//
//        ListNode dummyNode = new ListNode(-1);
//        dummyNode.next = head;
//        ListNode curNode  = dummyNode;
//        while (curNode.next != null && curNode.next.next != null){
//            if (curNode.next.val == curNode.next.next.val){
//                int x = curNode.next.val;
//                while (curNode.next != null && curNode.next.val == x){
//                    curNode.next = curNode.next.next;
//                }
//            }else {
//                curNode = curNode.next;
//            }
//        }
//        return dummyNode.next;

        ListNode dummyNode = new ListNode(-1);
        ListNode tail = dummyNode;
        ListNode curNode  = head;
        while (curNode != null){
            // 确保curNode与上一节点不同
            if (curNode.next == null || curNode.val != curNode.next.val){
                tail.next = curNode;
                tail = curNode;
            }
            // 如果 curNode 与下一节点相同，跳过相同节点
            while (curNode.next != null && curNode.val == curNode.next.val)
                curNode = curNode.next;
            curNode = curNode.next;  // 还需跳过当前节点
        }
        tail.next = null;  // 无论是否有相同节点，确保末尾指向null
        return dummyNode.next;
    }
}