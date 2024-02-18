def solution(n):
    answer=[]
    for i in range(1,int(n**0.5)+1):
        j=int(n/i)
        if n%i == 0 and (j%2 == 1 or i%2 ==1) :
            if j%2 ==1 and i%2 == 1:
                if i > j//2:
                    answer.append([i,j])
                if j > i//2:
                    answer.append([j,i])
                if i == j:
                    answer.pop()
                if j//2 >= i:
                    answer.append([i,j])
            elif i%2 == 1:
                if i//2 >= j:
                    answer.append([i,j])
                if j > i//2:
                    answer.append([j,i])
            else:
                if j//2 >= i:
                    answer.append([j,i])
                if i > j//2:
                    answer.append([i,j])
#    if n%2 ==1:
#        answer.append([0,0])
    return len(answer)

