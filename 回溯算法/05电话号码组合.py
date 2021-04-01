# 17. 电话号码的字母组合

def letterCombinations(digits: str):
    if digits == "":
        return []
    
    nums_dict = {2: 'abc', 3: 'def', 4: 'ghi', 5: 'jkl', 6: 'mno',
                    7: 'pqrs', 8: 'tuv', 9: 'wxyz'}
    
    digits_list = list(map(int, [i for i in digits]))

    res = []
    track = []
    di_length = len(digits_list)
    def backtrack(idx, track):
        if len(track) == di_length:
            res.append(''.join(track))
            return 

        n = digits_list[idx]  # 数字
        c = nums_dict[n]  # 字符集
    
        for i in range(len(c)):
            track.append(c[i])
            backtrack(idx+1, track)
            track.pop(-1)
    backtrack(0, [])
    return res
