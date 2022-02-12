// 冒泡排序
func bubbleSort(nums []int) {
	for i := 0; i < len(nums); i++ {
		flag := 1
		for j := i + 1; j < len(nums); j++ {
			if nums[i] > nums[j] {
				nums[i], nums[j] = nums[j], nums[i]
				flag = 0
			}
		}
		if flag == 1 {
			break
		}
	}
}