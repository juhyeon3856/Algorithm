def solution(s):
    memo = []
    for e in s:
        if not memo:
            memo.append(e)
        elif memo[-1] == e:
            memo.pop()
        else:
            memo.append(e)
    if len(memo)==0:
        answer = 1
    else:
        answer=0
    return answer