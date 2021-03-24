# 快速排序实现

def quicksort(li, left, right):
    if left >= right:
        return

    # mid = len(li) // 2
    l = left
    r = right
    base = li[l]  # 作为基准

    while left < right:
        while left<right and li[right] >= base:  # 先比较右部分
            right -= 1
        if li[right] < base:
            li[left] = li[right]  # 替换基准位置元素
            left += 1

        while left<right and li[left] <= base:  # 再比较左部分
            left += 1
        if li[left] > base:
            li[right] = li[left]
            right -= 1  
    li[left] = base  # 最后找到基准元素合理的位置

    quicksort(li, l, right-1)  # 左半部分同样方式排序
    quicksort(li, left+1, r)  # 右半部分同样方式排序

li=[22,33,49,47,33,12,68,29]
quicksort(li, 0, len(li)-1)
print(li)


