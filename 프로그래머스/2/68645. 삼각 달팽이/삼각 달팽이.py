def solution(n):
    answer = [0]*(n*(n+1)//2)
    fll = 1
    num = 0
    add = 0
    check = 0
    for i in range(n, 0, -1):
        check += 1
        if check % 3 == 1:
            for j in range(i):
                num += add
                answer[num] = fll
                add += 1
                fll += 1
        elif check % 3 == 2:
            for j in range(i):
                num += 1
                answer[num] = fll
                fll += 1
        else:
            for j in range(i):
                num -=  add
                answer[num] = fll
                add -= 1
                fll += 1
    return answer