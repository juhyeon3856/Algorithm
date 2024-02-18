def solution(n):
    if n%2 == 0:
        answer = [[1,2]]
    else:
        answer = [[1,0]]
    for i in range(n-1):
        if answer[-1][-1] == 0:
            add = p2(answer)
            answer = answer + [[1,2]] + add
        else:
            add = p1(answer)
            answer = answer + [[1,0]] + add
    answer = Oto3(answer)
    return answer

def Oto3(l):
    for i in range(len(l)):
        for j in range(2):
            if l[i][j] == 0:
                l[i][j] = 3
    return l

def p2(l):
    rst = []
    for i in l:
        apd = []
        for j in i:
            apd.append((j+2)%3)
        rst.append(apd)
    return rst

def p1(l):
    rst = []
    for i in l:
        apd = []
        for j in i:
            apd.append((j+1)%3)
        rst.append(apd)
    return rst