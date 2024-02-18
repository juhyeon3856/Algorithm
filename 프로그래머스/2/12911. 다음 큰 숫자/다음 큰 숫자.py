def solution(num):
    b=bin(num)
    n=len(b)
    c=0
    for i in range(n):
        a = b[n-i-1]
        if a == "1":
            c += 1
        elif c > 0:
            p = n-i-1
            break

    if n==c:
        answer = "1"+"0"+"1"*(n-1)
    else : 
        if b[n-1] == 1:
            answer = b[:p]+"1"+"0"+"1"*(c-1)
        else : 
            answer = b[:p]+"1"+"0"*(n-p-c)+"1"*(c-1)

    return int(answer , 2)