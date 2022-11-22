    /**
     * 678. 有效的括号字符串
     *
     * @param s
     * @return
     */
    public static boolean checkValidString(String s) {
        // 栈方法
        Deque<Integer> leftS = new LinkedList<>();
        Deque<Integer> starS = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char tmpC = s.charAt(i);
            if (tmpC == '(') {
                leftS.push(i);
            } else if (tmpC == '*') {
                starS.push(i);
            } else {
                if (!leftS.isEmpty()) {
                    // 优先匹配左括号
                    leftS.pop();
                } else if (!starS.isEmpty()) {
                    // 而后匹配星号*
                    starS.pop();
                } else {
                    // 没有左括号和星号都没有了，说明没法匹配剩余的右括号
                    return false;
                }
            }
        }
        // 检查余下的左括号和星号是否能够匹配上
        while (!leftS.isEmpty() && !starS.isEmpty()) {
            // 检查下标，只有左括号位于*左侧才是有效的
            if (leftS.pop() > starS.pop()) {
                return false;
            }
        }
        return leftS.isEmpty();
      
    }
