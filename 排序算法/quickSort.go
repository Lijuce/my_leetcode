// 快速排序
func quickSort(nums []int, left int, right int) {
	if left >= right {
		return
	}
	base := nums[left]
	var l = left
	var r = right
	for l != r {
		// 先从右边找
		for base <= nums[r] && l < r {
			r--
		}
		// 再从左边找
		for base >= nums[l] && l < r {
			l++
		}
		if l < r {
			nums[l], nums[r] = nums[r], nums[l]
		}
	}
	nums[left], nums[r] = nums[r], base
	quickSort(nums, left, l-1)
	quickSort(nums, r+1, right)
}