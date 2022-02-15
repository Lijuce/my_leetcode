package sort

type Heap struct {
	size  int
	array []int
}

// 堆排序
func HeapSort(nums []int) {
	// 创建大顶堆
	h := buildMaxHeap(nums)

	for h.size > 0 {
		// 和堆顶元素交换
		h.array[0], h.array[h.size-1] = h.array[h.size-1], h.array[0]
		// 堆尺寸减1
		h.size--
		// 调整堆
		adjustHeap(h, 0)
	}
}

func buildMaxHeap(nums []int) (h Heap) {
	h.size = len(nums)
	h.array = nums

	for i := h.size / 2; i >= 0; i-- {
		adjustHeap(h, i)
	}
	return
}

func adjustHeap(h Heap, parentNode int) {
	leftNode := 2*parentNode + 1
	rightNode := 2*parentNode + 2
	maxNode := parentNode
	if leftNode < h.size && h.array[maxNode] < h.array[leftNode] {
		maxNode = leftNode
	}
	if rightNode < h.size && h.array[maxNode] < h.array[rightNode] {
		maxNode = rightNode
	}
	if maxNode != parentNode {
		h.array[maxNode], h.array[parentNode] = h.array[parentNode], h.array[maxNode]
		adjustHeap(h, maxNode)
	}
}
