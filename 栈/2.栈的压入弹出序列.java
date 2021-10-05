class Solution {
    /**
     * 剑指 Offer 31. 栈的压入、弹出序列
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int len = pushed.length;
        // if (len == 1)
        //     return true;

        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        for (int n: pushed) {
            stack.push(n);
            while (!stack.isEmpty() && stack.peek() == popped[idx]) {
                stack.pop();
                idx ++;
            }
        }

        return idx == len;
    }
}