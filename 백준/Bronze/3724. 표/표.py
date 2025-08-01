T = int(input())

for t in range(1, T+1):
    M, N = map(int, input().split())

    arr = [list(map(int, input().split())) for _ in range(N)]
    mx = - 2**(35*1000)
    ans = 0

    for c in range(M):
        mul = 1
        for r in range(N):
            mul *= arr[r][c]
        if mx <= mul:
            ans = c+1
            mx = mul

    print(ans)