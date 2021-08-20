class Solution {
    /**
     * 20. 有效的括号
     * 法一：使用栈结构
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        int len = s.length();
        // 括号总长度为奇数，必定为无效括号
        if (len % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(')
                stack.push(')');
            else if (s.charAt(i) == '[')
                stack.push(']');
            else if (s.charAt(i) == '{')
                stack.push('}');
            // 碰到相反的符号，两种情况即非有效
            // 1. 栈内已为空，说明没有对应的括号匹配
            // 2. 栈内不为空，但是不符合对应匹配，无效
            else if (stack.isEmpty() || s.charAt(i) != stack.pop())
                return false;
        }
        return stack.isEmpty();
    }

    // 法二：直接替换字符串

}