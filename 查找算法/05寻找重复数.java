/**
 * 2021年4月18日
 * 287. 寻找重复数
 * 力扣热门100之一：查找算法思想
 */


class Solution {
    public int findDuplicate(int[] nums) {
    //     HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    //     // 先排序
    //     Arrays.sort(nums);
    //     // 哈希表存值
    //     for (int i = 0; i < nums.length; i++){
    //         if (map.containsKey(nums[i])){
    //             int v = map.get(nums[i]);
    //             map.put(nums[i], ++v);
    //         }else{
    //             map.put(nums[i], 1);
    //         }
    //         if (map.get(nums[i]) > 1)
    //             return nums[i];
    //     }
    //     return 0;
        int target = 0;
        int mid = (1 + nums.length) / 2;
        int left = 1;
        int right = nums.length-1;
        while (left < right){
            int count = 0;
            mid = (left + right) / 2;
            for (int n: nums){
                if ( n <= mid )
                    count ++;  // 小等于mid的数量
            }
            if ( count > mid){
                right = mid;                
            }else{
                left = mid+1;
            }
        }
        return left;


    }
}