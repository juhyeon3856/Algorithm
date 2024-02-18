def solution(n):
    answer = 0  
    for i in range(n//2 + 1):
        answer = answer + combi(n-i,i)
    return answer%1234567


def combi(n,r):
    com = 1
    for i in range(n-r+1,n+1):
        com = com * i
    for j in range(1,r+1):
        com = com // j
    return int(com)
        