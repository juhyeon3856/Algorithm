T = int(input())


def dfs(depth):
    if depth == N:
        calc()
        return
    for nxt in (" ", "+", "-"):
        ans[depth] = nxt
        dfs(depth + 1)


def calc():
    result = 0
    oper = "+"
    num = 1
    for i in range(1, N+1):
        if ans[i] == ' ':
            num = num * 10 + (i + 1)
        elif ans[i] == '+':
            if oper == '+':
                result += num
            else:
                result -= num
            num = i + 1
            oper = '+'
        else:
            if oper == '+':
                result += num
            else:
                result -= num
            num = i + 1
            oper = '-'

    if result == 0:
        print(1, end="")
        for i in range(1, N):
            print(f"{ans[i]}{i + 1}", end="")
        print()


for t in range(T):
    N = int(input())
    ans = ["."] * (N + 1)
    dfs(1)

    print()