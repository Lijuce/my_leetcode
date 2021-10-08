/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    Node head, prev;

    /**
     * 剑指 Offer 36. 二叉搜索树与双向链表
     * 利用二叉搜索树的有序性，结合中序遍历框架思想 + 双向链表指针操作
     * @param root
     * @return
     */
    public Node treeToDoublyList(Node root) {
        if (root == null)
            return root;
        dfs(root);
        // 最后首尾相连
        head.left = prev;
        prev.right = head;
        return head;
    }

    public void dfs(Node cur) {
        if (cur == null)
            return;
        dfs(cur.left);
        if (prev == null) {
            // 此处只会进入以此，仅为保存最小节点
            head = cur;
        } else {
            // 此时prev已保存了上一次的节点记录，需更新后继节点指针
            prev.right = cur;
            // 更新前驱节点
            cur.left = prev;
        }
        prev = cur;
        // 最后迭代完，prev指向双链表中的尾节点
        dfs(cur.right);
    }
}