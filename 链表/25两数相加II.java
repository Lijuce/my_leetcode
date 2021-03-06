class Solution{
    /**
     * 445. 两数相加 II
     * 逆序处理首先应该想到 栈 
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode head = null;
        while (!s1.isEmpty() || !s2.isEmpty() || carry > 0){
            int sum = carry;
            if (!s1.isEmpty())
                sum += s1.pop();
            if (!s2.isEmpty())
                sum += s2.pop();
            ListNode newNode = new ListNode(sum%10);
            carry = sum / 10;
            newNode.next = head;  // 头插法
            head = newNode;
        }
        return head;
    }
}