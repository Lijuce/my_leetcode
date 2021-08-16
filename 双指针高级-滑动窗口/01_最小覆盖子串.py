# 76. 最小覆盖子串
# 初始滑动窗口   2021年4月4日

import collections

def minWindow(s: str, t: str) -> str:
    left = right = 0

    valid = 0  # 记录满足needs时的大小
    # window = {}  # 空内容的窗口
    # needs = {}  # 需满足的窗口内容
    # for i in t:  # 此处可用内置模块collection.Counter()
    #     if i not in window:
    #         window[i] = 0
    #         needs[i] = 0
    #     needs[i] += 1
    window = collections.Counter()    
    needs = collections.Counter(t)

    start, length = 0, float('inf')
    sLen, nLen = len(s), len(needs)
    while right < sLen:
        c = s[right]  # 移入窗口的字符
        right += 1  # 右移窗口
        if c in needs:
            window[c] += 1
            if needs[c] == window[c]:
                valid += 1

        while valid == nLen:  # 开始判断左窗口是否需要收缩
            if right - left < length:
                start = left
                length = right - left
            
            d = s[left]  # 要移出窗口的字符
            left += 1  # 左窗口收缩
            if d in needs:
                if window[d] == needs[d]:
                    valid -= 1
                window[d] -= 1
    return '' if length == float('inf') else s[start:start+length]