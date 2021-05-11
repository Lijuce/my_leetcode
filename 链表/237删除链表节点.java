public void deleteNode(ListNode node) {
    ListNode curNode = node;
    ListNode prev = null;
    while (curNode.next != null){
        prev = curNode;
        curNode.val = curNode.next.val;
        curNode = curNode.next;
    }
    prev.next = null;

    /**
     * 237 删除链表节点
     * 此题有点像脑筋急转弯，因为此处不可能直接删除节点本身，而是以改变节点值的方式进行删除
     */
    // 第 1 步：把待删除结点的下一结点的值赋值给自己
    ListNode nextNode = node.next;
    node.val = nextNode.val;

    // 第 2 步：删除下一个结点
    node.next = nextNode.next;
    nextNode.next = null;
}
