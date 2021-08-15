# 3. 无重复字符的最长子串
# 此题相比前三题较为不同，注意窗口内容应该是保持每个字符的频次为1，即不重复

def lengthOfLongestSubstring(s: str) -> int:
    left = right = 0
    # window = collections.Counter()
    window = {}  # 空内容的窗口
    for i in s:  # 此处可用内置模块collection.Counter()
        if i not in window:
            window[i] = 0

    maxLen, sLen = 0, len(s)
    while right < sLen:
        c = s[right]
        right += 1

        # 更新窗口内容
        window[c] += 1

        # 左窗口收缩条件
        while window[c] > 1:  # 表明有重复字符
            d = s[left]
            left += 1  
            window[d] -= 1  # 将窗口内重复字符的频次减1

        maxLen = max(maxLen, right-left)

    return maxLen

    