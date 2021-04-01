# 5. 最长回文子串

def longestPalindrome(s: str) -> str:

    # 中心扩散思想-双指针实现    
    def palindrome(s, l, r):  # 单独判断是否回文串
        while l>=0 and r<=len(s)-1 and s[l]==s[r]:
            l -= 1
            r += 1
        return s[l+1:r]  # 此处l+1，因为在最后的时候在不符合while判断之前加了一次，属于额外加的数，因此需要-1
                         # 额r，则是因为不包括r边界在内
    
    res = ''
    for i in range(len(s)):
        s1 = palindrome(s, i, i)
        s2 = palindrome(s, i, i+1)  # i+1为了应对字符串长度为偶数的情况

        if len(s1) > len(res):
            res = s1
        if len(s2) > len(res):
            res = s2
    
    return res
