# 647. 回文子串(计算子串数)

def countSubstrings(s: str) -> int:

    # 中心扩散思想-双指针技巧
    global count
    count = 0
    def palindrome(s, l, r):  # 单独判断是否回文串
        global count
        while l>=0 and r<=len(s)-1 and s[l]==s[r]:
            l -= 1
            r += 1
            count += 1
    
    for i in range(len(s)):
        s1 = palindrome(s, i, i)
        s2 = palindrome(s, i, i+1)  # i+1为了应对字符串长度为偶数的情况
    
    return count


