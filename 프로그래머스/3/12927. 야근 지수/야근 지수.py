def solution(n, works):
    if sum(works) <= n:
        return 0
    answer = 0
    d = {}
    for w in works:
        if w in d:
            d[w] += 1
        else:
            d[w] = 1
    M = max(d)
    while(n > 0):
        if M-1 in d:
            d[M-1] += d[M]
        else:
            d[M-1] = d[M]
        n -= d[M]
        del(d[M])
        M = max(d)
    if n < 0:
        d[M+1] = -1*n
        d[M] += n
    for x in d:
        answer += (x**2) * d[x]
    return answer