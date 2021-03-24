# 冒泡排序

def bubble_sort(li):
    for i in range(1, len(li)):
        flag = 1
        for j in range(0, len(li)-i):
            if li[j] > li[j+1]:
                li[j+1], li[j] = li[j], li[j+1]
                flag = 0
        if flag == 1:
            break


li=[22,33,49,47,33,12,68,29]
bubble_sort(li)
print(li)
