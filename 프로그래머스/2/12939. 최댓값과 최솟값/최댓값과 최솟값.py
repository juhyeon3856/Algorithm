def solution(s):
    L = list( map(int , s.split() ))
    M = max(L)
    m = min(L)
    answer = str(m)+" "+str(M)
    return answer