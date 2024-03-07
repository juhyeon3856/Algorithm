def transf(num, n):
    if num%n >= 10:
        result = chr(num%n + 55)
    else:
        result = str(num%n)
    div = n
    r = 1
    if div > num:
        if num >= 10:
            result = chr(num+55)
        else: 
            result = str(num)
    while div <= num:
        div *= n
        r = (num%div)//(div//n)
        if r >= 10:
            result = chr(r+55) + result
        else:
            result = str(r) + result
    return result

def solution(n, t, m, p):
    answer = ''
    i = 0
    _all = ""
    while len(_all) <= t*m - m + p:
        _all = _all + transf(i, n)
        i += 1
    for k in range(t):
        answer = answer + _all[p-1+k*m]
    return answer