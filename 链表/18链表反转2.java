public class solution {

    /**
     * 迭代方式实现链表前N个元素反转
     * @param head
     * @param N
     * @return
     */
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
     * 方法一：
     * 链表连续区间元素反转-此方法调用了reverseLinkPreN
     * @param head
     * @param start
     * @param end
     * @return
     */
    public static LinkNode reverseLinkBetweenIter(LinkNode head, int start, int end){
        int index = 1;
        LinkNode cur = head;
        LinkNode prev = null;
        while (cur != null && index < start){
            prev = cur;
            cur = cur.next;
            index ++;
        }
        LinkNode linkNode = reverseLinkPreN(cur, end - start + 1);
        prev.next = linkNode;
        return head;
    }

    /**
     * 直截了当的做法
     * @param head
     * @param start
     * @param end
     * @return
     */
    public static LinkNode reverseLinkBetween(LinkNode head, int start, int end){
        LinkNode dummyNode = new LinkNode(-1); // 设置虚拟头节点
        dummyNode.next = head;
        LinkNode prev = dummyNode;
        for (int i = 1; i < start; i++){
            prev = prev.next;  // 指定开始节点
        }

        LinkNode cur = prev.next;
        LinkNode successor;
        LinkNode prevTail = prev;  // 保留start的前一个节点
        prev = null;
        LinkNode startHead = cur;
        for (int i = 1; i < end - start + 2; i++){
            successor = cur.next;
            cur.next = prev;
            prev = cur;
            cur = successor;
        }
        startHead.next = cur;
        prevTail.next = prev;
        return dummyNode.next;
    }

}
