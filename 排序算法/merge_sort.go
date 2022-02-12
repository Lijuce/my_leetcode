package main

import "fmt"

func main() {
	var nums = []int{22, 33, 49, 47, 33, 12, 68, 29, 22}
	nums = mergeSort(nums)
	fmt.Println(nums)
}

// 归并排序
func mergeSort(arrays []int) []int {
	if len(arrays) < 2 {
		return arrays
	}
	mid := len(arrays) / 2
	leftArr := mergeSort(arrays[0:mid])
	rightArr := mergeSort(arrays[mid:])
	return merge(leftArr, rightArr)
}

func merge(arr1 []int, arr2 []int) []int {
	newArr := make([]int, 0)
	l := 0
	r := 0
	for l < len(arr1) && r < len(arr2) {
		if arr1[l] < arr2[r] {
			newArr = append(newArr, arr1[l])
			l++
		} else {
			newArr = append(newArr, arr2[r])
			r++
		}
	}

	newArr = append(newArr, arr1[l:]...)
	newArr = append(newArr, arr2[r:]...)
	return newArr
}