class TreeNode(object):
    def __init__(self):
        self.left = -1  # 区间左端点
        self.right = -1  # 区间右端点
        self.sum_num = 0  # 区间和 (存储状态)

class Tree(object):
    def __init__(self, n, arr):
        self.n = n
        self.max_size = 4 * n
        self.tree = [TreeNode() for i in range(self.max_size)]  # 维护一个TreeNode数组
        self.arr = arr
    
    # index从1开始
    def _build(self, index, left, right):
        self.tree[index].left = left
        self.tree[index].right = right
        if left == right:
            self.tree[index].sum_num = self.arr[left - 1]
        else:
            mid = (left + right) // 2
            self._build(index * 2, left, mid)
            self._build(index * 2 + 1, mid + 1, right)
            # self.pushup_sum(index)
            self.tree[index].sum_num = self.tree[index * 2].sum_num + self.tree[index * 2 + 1].sum_num  # 求和（即线段树里的状态合并）

    # 构建线段树
    def build(self):
        self._build(1, 1, self.n)

    # 更新操作
    def _update(self, point, val, i, l, r):
        if self.tree[i].left == self.tree[i].right:
            self.tree[i].sum_num += val
        else:
            mid = (l+r) // 2
            if point <= mid:
                self._update(point, val, i*2, l, mid)
            else:
                self._update(point, val, i*2 + 1, mid+1, r)
            self.tree[index].sum_num = self.tree[i * 2].sum_num + self.tree[i * 2 + 1].sum_num  # 求和（即线段树里的状态合并）
            
    # 单点更新
    def update(self, point, val):
        """
        point: 要更新的数在数组的下标 
        val: 更新的值
        """
        self._update(point, val, 1, 1, self.n)

    # 查询操作
    def _query(self, ql, qr, i, l, r, ):
        if l >= ql and r <= qr:  # 若当前范围包含于要查询的范围
            return self.tree[i].sum_num
        else:
            mid = (l + r) // 2
            res_l = 0
            res_r = 0
            if ql <= mid:  # 左子树最大的值大于了查询范围最小的值-->左子树和需要查询的区间交集非空
                res_l = self._query(ql, qr, i * 2, l, mid, )
            if qr > mid:  # 右子树最小的值小于了查询范围最大的值-->右子树和需要查询的区间交集非空
                res_r = self._query(ql, qr, i * 2 + 1, mid + 1, r, )
            return res_l + res_r

    # 区间查询
    def query(self, ql, qr):
        return self._query(ql, qr, 1, 1, self.n)

    