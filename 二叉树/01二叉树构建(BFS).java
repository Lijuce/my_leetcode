public static Node constructTree(Integer[] datas){
    // 层次遍历构造二叉树
    Node root = new Node(datas[0]);  // 根节点
    LinkedList<Node> queue = new LinkedList<>();
    queue.offer(root);

    for (int i = 1; i < datas.length; i+=2){
        Node peek = queue.poll();
        Integer val = datas[i];
        if (val != null){
            Node node = new Node(val);
            peek.left = node;
            queue.offer(node);
        }else {
            peek.left = null;
        }
        if (i+1 < datas.length){
            if (val != null){
                val = datas[i+1];
                Node node = new Node(val);
                peek.right = node;
                queue.offer(node);
            }else {
                peek.right = null;
            }
        }
    }
    return root;
}