def connect(tree, num, check, comNum, n):
    check[comNum] = num
    for i in range(n):
        if check[i] == 0 and tree[comNum][i] == 1:
            check = connect(tree, num, check, i, n)
    return check

def solution(n, computers):
    num = 0
    check = [0] * n
    for i in range(n):
        if check[i] == 0:
            num -= 1
            check = connect(computers, num, check, i, n)
    return abs(num)