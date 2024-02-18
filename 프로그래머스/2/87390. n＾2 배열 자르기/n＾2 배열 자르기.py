def solution(n, left, right):
    answer = []
    for i in range(left, right+1):
        x,y = point(i,n)
        answer.append(val(x,y))
    return answer
def point(i,n):
    return i%n , i//n
def val(x,y):
    if x<y: 
        return y+1
    else: 
        return x+1
    