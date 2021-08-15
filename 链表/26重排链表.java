public class Solution {
    /**
     * 143. 重排链表
     * 解法一;拷贝链表值数组中，利用下标进行重排序
     * @param head
     */
    public void reorderList1(ListNode head) {
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode node = head;
        // 拷贝链表至数组
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int i = 0;
        int j = list.size()-1;
        // 开始重排序，直到两边的下标指针在中间相遇
        while (i < j) {
            list.get(i).next = list.get(j);
            i ++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j --;
        }
        list.get(i).next = null;
    }

    /**
     * 解法二：先获取中间节点，后半段反转链表，然后拼接两个链表
     * @param head
     */
    public void reorderList2(ListNode head) {
        // 利用双指针获取中间节点
        ListNode midNode = null;
        ListNode fastNode = head;
        ListNode slowNode = head;
        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }
        midNode = slowNode.next;
        slowNode.next = null;

        // 反转后半段链表
        ListNode curNode = midNode;
        ListNode prev = null;
        ListNode back;
        while (curNode != null) {
            back = curNode.next;
            curNode.next = prev;
            prev = curNode;
            curNode = back;
        }

        // 两个链表拼接
        ListNode left = head;
        ListNode right = prev;
        while (left != null && right != null) {
            ListNode left_temp = left.next;
            ListNode right_temp = right.next;

            left.next = right;
            left = left_temp;

            right.next = left;
            right = right_temp;
        }
    }
}