public class Solution{

    /**
     * 回文数检测
     * @param x
     * @return
     */
    public boolean isPalindrome(int x){
        if (x < 0 || (x!=0 && x%10==0))
            return false;
        int res = 0;
        int t = x;
        while (t > 0){
            int temp = t % 10;
            t = t / 10;
            res = res * 10 + temp;
        }
        return res == x;
    }

    /**
     * 回文链表检测
     * 双指针思想+迭代反转链表
     * @param head
     * @return
     */
    public boolean isPalindrome(LinkNode head) {
        // 利用双指针寻找中间节点
        LinkNode fast = head;
        LinkNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null){  // 说明链表长度为奇数，慢指针需再前往一步
            slow = slow.next;  // 已找到中间点，并将其作为后半部分的头结点
        }
        // 反转链表
        LinkNode linkNode = reverseSingleLinkIter(slow);
        while (linkNode != null){
            if (head.val != linkNode.val)
                return false;
            linkNode = linkNode.next;
            head = head.next;
        }
        return true;

    }
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
}
