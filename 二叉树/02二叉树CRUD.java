public static void printTree(Node root) {
    // 前序遍历输出(递归法)
//        if (root == null)
//            return;
//        if (root.val != null)
//            System.out.println(root.val);
//        printTree(root.left);
//        printTree(root.right);
//
    // 后续遍历输出(递归)
//        if (root == null)
//            return;
//        printTree(root.left);
//        printTree(root.right);
//        if (root.val != null)
//            System.out.println(root.val);
    // (非递归)单栈法
       if (root != null){
           Stack<Node> nodeStack = new Stack<>();
           Node node;
           nodeStack.push(root);
           while (!nodeStack.isEmpty()){  // 遍历栈内所有节点
               node = nodeStack.peek();  // 观察栈顶节点
               if (node.left != null && root != node.left && root != node.right){
                   nodeStack.push(node.left);
               }else if (node.right != null && root != node.right){
                   nodeStack.push(node.right);
               }else {
                   System.out.println(nodeStack.pop().val);
                   root = node;
               }
           }
       }

    // (非递归)双栈法
    if (root != null){
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()){
            root = s1.pop();
            s2.push(root);
            if (root.left != null){
                s1.push(root.left);
            }
            if (root.right != null){
                s1.push(root.right);
            }
        }
        while (!s2.empty()){
            System.out.println(s2.pop().val);
        }
    }



}