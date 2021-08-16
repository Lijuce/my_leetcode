# 438. 找到字符串中所有字母异位词

def findAnagrams(s: str, p: str):
    left = right = 0

    valid = 0  # 记录满足needs时的大小
    # window = collections.Counter()
    # needs = collections.Counter(p)
    window = {}  # 空内容的窗口
    needs = {}  # 需满足的窗口内容
    for i in p:  # 此处可用内置模块collection.Counter()
        if i not in window:
            window[i] = 0
            needs[i] = 0
        needs[i] += 1
    res = []
    sLen, pLen, nLen = len(s), len(p), len(needs)
    while right < sLen:
        c = s[right]  # 移入窗口的字符
        right += 1  # 右移窗口
        # 更新窗口内容
        if c in needs:
            window[c] += 1
            if needs[c] == window[c]:
                valid += 1

        while right - left >= pLen:  # 开始判断左窗口是否需要收缩
            if valid == nLen:
                res.append(left)  # 与上题不同之处：只需要左窗口的索引位置

            d = s[left]  # 要移出窗口的字符
            left += 1  # 左窗口收缩
            if d in needs:
                if window[d] == needs[d]:
                    valid -= 1
                window[d] -= 1
    return res