# 337. 打家劫舍 III

# 动态规划+二叉树后续遍历框架

class Solution:
    def rob(self, root: TreeNode) -> int:
        def _rob(root):
            if root is None:
                return 0, 0

            ld, lnd = _rob(root.left)
            rd, rnd = _rob(root.right)

            return root.val+lnd+rnd, max(ld, lnd)+max(rd, rnd)
        return max(_rob(root))

def rob(root: Node) -> int:
    def _rob(root):
        if root is None:  
            return 0, 0 # base case
        
        ld, lnd = _rob(root.left)  # ld选择抢的结果，lnd选择不抢的结果
        rd, rnd = _rob(root.right)

        val_do = root.val+lnd+rnd  # 选择抢,则下家必定不能抢
        val_ndo = max(ld, lnd)+max(rd, rnd)  # 选择不抢，则下家抢或不抢，按金额择优

        return val_do, val_ndo
        
