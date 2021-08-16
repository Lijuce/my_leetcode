# 2021年4月9日
# 力扣热门100题之一
# 437. 路径总和 III
# 此题还需多加理解

def pathSum(self, root: TreeNode, sum_: int) -> int:
    #思路：前缀和
    #递归进入左右子树后，回到当前层，要把当前节点添加的前缀和去除，避免回溯之后影响上一层。

    # def dfs(root, hashmap, target,presum):
    #     #终止条件
    #     if not root:
    #         return 0
    #     #本层要做的事情
    #     cnt=0
    #     presum += root.val            
    #     if (presum - target) in hashmap:
    #         cnt += hashmap[presum - target]
    #     if presum not in hashmap:
    #         hashmap[presum] = 1
    #     else:
    #         hashmap[presum]+=1
    #     #进入下一层
    #     cnt+=dfs(root.left, hashmap, target,presum)
    #     cnt+=dfs(root.right, hashmap, target,presum)
    #     #！！！重要：回到本层 
    #     hashmap[presum]-=1
    #     return cnt

    # hashmap = {0:1}
    # r = dfs(root, hashmap,sum,0)

    # return r

    # def dfs(root, sumlist):
    #     if root is None: return 0
    #     sumlist = [num + root.val for num in sumlist] + [root.val]
    #     return sumlist.count(sum) + dfs(root.left, sumlist) + dfs(root.right, sumlist)
    # return dfs(root, [])


    def dfs(root, sumlist):
        if root is None:
            return 0
        
        sumlist = [num+root.val for num in sumlist]
        sumlist.append(root.val)
        
        count = 0
        for num in sumlist:
            if num == sum_:
                count += 1
        # count = sumlist.count(sum)

        return count + dfs(root.left, sumlist) + dfs(root.right, sumlist)

    return dfs(root, [])
