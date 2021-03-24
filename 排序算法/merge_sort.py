# 归并排序-自顶向下递归

def merge(left, right):
    result = []
    while left and right:  # 两部分的元素作比较
        if left[0] <= right[0]:
            result.append(left.pop(0))  # 小的先加入列表中
        else:
            result.append(right.pop(0))

    # 确保两部分的元素都已归并
    if left:
        result.extend(left)
    if right:
        result.extend(right)
    
    return result

def mergeSort(arr):
    if(len(arr)<2):
        return arr
    
    middle = len(arr) // 2
    left, right = arr[0: middle], arr[middle:]
    arr_left = mergeSort(left)  # 先对左半部分排序
    arr_right = mergeSort(right)  # 再对右半部分排序
    return merge(arr_left, arr_right)

arr = [22,33,49,47,33,12,68,29,22]
print(mergeSort(arr))