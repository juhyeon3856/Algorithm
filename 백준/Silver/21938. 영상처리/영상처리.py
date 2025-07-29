import sys
sys.setrecursionlimit(500000)


def input_func(data):
    result = []
    for i in range(0, M*3, 3):
        result.append(data[i] + data[i + 1] + data[i + 2])
    return result


dr = [-1, 1, 0, 0]
dc = [0, 0, 1, -1]


def dfs(fr, fc):
    visited[fr][fc] = 1
    for d in range(4):
        nr, nc = fr + dr[d], fc + dc[d]
        if 0<=nr<N and 0<=nc<M:
            if visited[nr][nc]:
                continue
            if arr[nr][nc] < T:
                continue
            dfs(nr, nc)


N, M = map(int, input().split())
arr = [input_func(list(map(int, input().split()))) for _ in range(N)]
visited = [[0] * M for _ in range(N)]

T = int(input()) * 3

ans = 0
for r in range(N):
    for c in range(M):
        if arr[r][c] >= T and not visited[r][c]:
            dfs(r, c)
            ans += 1

print(ans)
