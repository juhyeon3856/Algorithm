def solution(brown, yellow):
    answer = divisor(yellow)
    for i in range(len(answer)):
        if (answer[i][0]+answer[i][1]+2)*2 == brown:
            n=i
            break
    return [answer[n][0]+2,answer[n][1]+2]



def divisor(n):
    L=[]
    for i in range(1,int(n**0.5)+1):
        if n%i == 0:
            L.append([n//i,i])
    return L