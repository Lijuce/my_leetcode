class Solution {
    HashMap<String, Integer> map = new HashMap<>();
    List<TreeNode> res = new LinkedList<TreeNode>();

    /**
     * 652寻找重复子树
     * 后续遍历递归
     * 运用序列化思想
     * @param root
     * @return
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null)
            return null;
        func(root);
        return res;
    }
    public String func(TreeNode root){
        if (root == null)
            return "#";
        String left = func(root.left);
        String right = func(root.right);

        String subTree = left + "," + right + "," + root.val;
        int freq = map.getOrDefault(subTree, 0);
        if (freq == 1)  // 当再次调用到相同子串时，表明有重复，即知道freq=1
            res.add(root);  // 由此，即使有多次重复都不会再添加入res中
        map.put(subTree, freq+1);

        return subTree;
    }
}