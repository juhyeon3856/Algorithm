# 복잡도 20 C 10

N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]
R = N // 2


def combi(depth, start):
    if depth == R:
        ans[0] = min(ans[0], clac())
        return
    for i in range(start, N):
        visited[i] = 1
        combi(depth + 1, i + 1)
        visited[i] = 0


def clac():
    tot0, tot1 = 0, 0
    for i in range(N):
        for j in range(i + 1, N):
            if visited[i] == visited[j] == 0:
                tot0 += arr[i][j] + arr[j][i]
            elif visited[i] == visited[j] == 1:
                tot1 += arr[i][j] + arr[j][i]
    return abs(tot0 - tot1)


ans = [float("inf")]
visited = [0] * N
combi(0, 0)
print(ans[0])