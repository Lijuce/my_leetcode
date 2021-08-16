class Solution {
    /**
     * 剑指 Offer 35. 复杂链表的复制 / 138. 复制带随机指针的链表
     * 法一：利用HashMap结构作映射
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null)
            return head;
        Node curNode = head;
        Node dummyNode = new Node(0);
        // 先构建原链表节点到新链表节点的映射
        // (原节点，拷贝节点)
        HashMap<Node, Node> map = new HashMap<>();
        while (curNode != null) {
            map.put(curNode, new Node(curNode.val));
            curNode = curNode.next;
        }

        // 按照要求拼接拷贝的新节点，组成新链表
        curNode = head;
        while (curNode != null) {
            map.get(curNode).next = map.get(curNode.next);
            map.get(curNode).random = map.get(curNode.random);
            curNode = curNode.next;
        }
        // 返回结果（新链表）
        return map.get(head);
    }

    /**
     * 法二：原地更改-空间复杂度优化
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null)
            return head;
        Node curNode = head;
        Node tempNode;
        Node copyNode;
        // 在原节点后拷贝新节点
        while (curNode != null) {
            copyNode = new Node(curNode.val);
            copyNode.next = curNode.next;
            curNode.next = copyNode;
            curNode = curNode.next.next;
        }
        // 拷贝随机指针
        curNode = head;
        while (curNode != null) {
            // 需要判断random.next是否存在
            if (curNode.random != null){
                curNode.next.random = curNode.random.next;
            }
            curNode = curNode.next.next;
        }
        // 将拷贝节点从原节点中分离出来
        curNode = head;
        Node dummy = curNode.next;
        Node temp;
        while (curNode != null && curNode.next != null) {
            temp = curNode.next; // 跳至拷贝节点
            curNode.next = curNode.next.next;
            curNode = temp; 
        }
        return dummy;
    }
}