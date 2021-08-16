public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode slow = head;
    ListNode fast = head;
    
    while(n > 0){
        n -= 1;
        fast = fast.next;
    }
    if (fast == null) return head.next;
    while (fast != null && fast.next != null){
        fast = fast.next;
        slow = slow.next;
    }
    slow.next = slow.next.next;

    return head;
    
}