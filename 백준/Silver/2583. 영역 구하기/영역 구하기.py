import sys

sys.setrecursionlimit(10000)

dr = [-1, 1, 0, 0]
dc = [0, 0, 1, -1]


def dfs(fr, fc):
    visited[fr][fc] = 1
    result = 1  # 하위 노드들 합 + 본인(1)
    for d in range(4):
        nr, nc = fr + dr[d], fc + dc[d]
        if 0 <= nr < N and 0 <= nc < M:
            if visited[nr][nc]: continue
            if arr[nr][nc]:  # 갈수있는곳
                result += dfs(nr, nc)
    return result


M, N, K = map(int, input().split())

arr = [[1] * M for _ in range(N)]
visited = [[0] * M for _ in range(N)]

ans = []

for _ in range(K):
    sr, sc, er, ec = map(int, input().split())
    for r in range(sr, er):
        for c in range(sc, ec):
            arr[r][c] = 0  # 0이 못가는곳

for r in range(N):
    for c in range(M):
        if arr[r][c] and not visited[r][c]:
            ans.append(dfs(r, c))

ans.sort()
print(len(ans))
print(*ans)