# 堆排序

def heapSortWithArray():
    # 数组方式实现
    def swap(arr, i, j):
        tmp = arr[i]
        arr[i] = arr[j]
        arr[j] = tmp

    def heapify(arr, i):  # 堆调整（堆化）
        left = 2*i + 1
        right = 2*i + 2
        largest = i
        if left < arrLen and arr[left] > arr[largest]:
            largest = left
        if right < arrLen and arr[right] > arr[largest]:
            largest = right

        if largest != i:
            swap(arr, i, largest)  # 不符合大顶堆性质，将两端元素做交换
            heapify(arr, largest)  # 子节点 顶堆调整

    def buildMaxHeap(arr):  # 建立大顶堆
        max_idx = len(arr)//2  # 数组构建的顶堆，只需检查其一半元素
        for i in range(max_idx, -1, -1):
            heapify(arr, i)

    arr = [22,33,49,47,33,12,68,29]
    arrLen = len(arr)
    buildMaxHeap(arr)  # 首先建立大顶堆
    for i in range(len(arr)-1, 0, -1):
        swap(arr, 0, i)  # 和堆订元素交换
        arrLen -= 1  # 堆尺寸减1
        heapify(arr, 0)  # 再次调整确保为大顶堆
    print(arr)

### 算法步骤
# 1、创建一个堆 H[0……n-1]；
# 2、把堆首（最大值）和堆尾互换；
# 3、把堆的尺寸缩小 1，并调用 shift_down(0)，目的是把新的数组顶端数据调整到相应位置；
# 4、重复步骤 2，直到堆的尺寸为 1。
from BaseLink import *

# 链表方式实现
def swap(arr, i, j):
    arr[i], arr[j] = arr[j], arr[i]

def heapify(link, i):  # 堆调整（堆化）
    left = 2*i + 1
    right = 2*i + 2
    largest = i
    if left < arrLen and link[left] > link[largest]:
        largest = left
    if right < arrLen and link[right] > link[largest]:
        largest = right

    if largest != i:
        swap(link, i, largest)  # 不符合大顶堆性质，将两端元素做交换
        heapify(link, largest)  # 子节点 顶堆调整

def buildMaxHeap(arr):  # 建立大顶堆
    max_idx = len(arr)//2  # 数组构建的顶堆，只需检查其一半元素
    for i in range(max_idx, -1, -1):
        heapify(arr, i) 

# 链表堆排序
from collections import deque
arr = [22,33,49,47,33,12,68,29]
arrLen = len(arr)
l = deque(arr)  
buildMaxHeap(l)
for i in range(len(arr)-1, 0, -1):
    swap(l, 0, i)  # 和堆订元素交换
    arrLen -= 1  # 堆尺寸减1
    heapify(l, 0)  # 再次调整确保为大顶堆
print(l)
