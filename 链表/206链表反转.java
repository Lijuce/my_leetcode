public class solution {

    /**
     * 迭代法反转单链表
     * @param head
     * @return
     */
    public static LinkNode reverseSingleLinkIter(LinkNode head){
        LinkNode cur = head;
        LinkNode prev = null;
        LinkNode back;
        while (cur != null){
            back = cur.next;
            cur.next = prev;
            prev = cur;
            cur = back;
        }
        head = prev;
        return head;
    }

    /**
     * 递归反转链表
     * @param head
     * @return
     */
    public static LinkNode reverseSingleLinkRec(LinkNode head){
        if (head.next == null){
            return head;
        }
        LinkNode last = reverseSingleLinkRec(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}