public class Solution {
    public static LinkNode reverseKGroup(LinkNode head, int K){
        int count = 0;
        LinkNode start = head;
        LinkNode obj = head;
        while (count < K){
            obj = obj.next;
            if (obj == null)
                return head;
            count ++;
        }

        LinkNode newHead = reverseSingleLinkIter(start, obj);
        start.next = reverseKGroup(obj, K);
        return newHead;
    }

    public static LinkNode reverseLinkPreN(LinkNode head, int N){
        int index = 1;
        LinkNode cur = head;
        LinkNode back;
        LinkNode prev = null;
        while (cur != null  && index <= N){
            back = cur.next;
            cur.next = prev;
            prev = cur;
            cur = back;
            index ++;
        }
        head.next = cur;
        return prev;
    }

    /**
     * 迭代反转整体单链表
     * @param start
     * @param end
     * @return
     */
    public static LinkNode reverseSingleLinkIter(LinkNode start, LinkNode end){
        LinkNode cur = start;
        LinkNode successor = null;
        LinkNode prev = null;
        while (cur != end){
            successor = cur.next;
            cur.next = prev;
            prev = cur;
            cur = successor;
        }
        return prev;
    }
}