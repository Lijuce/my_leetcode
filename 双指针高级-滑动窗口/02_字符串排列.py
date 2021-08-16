# 567. 字符串的排列  2021年4月4日

import collections

def checkInclusion(s1: str, s2: str) -> bool:
    # 与最小覆盖子串相似
    # 当作：s2是否存在长度与s1相等，并且可覆盖s1的最小子串
    left = right = 0

    valid = 0  # 记录满足needs时的大小
    window = collections.Counter()
    needs = collections.Counter(s1)

    sLen = len(s2)
    while right < sLen:
        c = s2[right]  # 移入窗口的字符
        right += 1  # 右移窗口
        # 更新窗口内容
        if c in needs:
            window[c] += 1
            if needs[c] == window[c]:
                valid += 1

        while right - left >= len(s1):  # 开始判断左窗口是否需要收缩
                                        # 因为判断s1的排列，因此长度与s1相等
            if valid == len(needs):
                return True

            d = s2[left]  # 要移出窗口的字符
            left += 1  # 左窗口收缩
            if d in needs:
                if window[d] == needs[d]:
                    valid -= 1
                window[d] -= 1
    return False