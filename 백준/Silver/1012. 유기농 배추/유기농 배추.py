import sys
sys.setrecursionlimit(10000)

dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]


def dfs(fr, fc):
    visited[fr][fc] = 1

    for d in range(4):
        nr, nc = fr + dr[d], fc + dc[d]
        if 0 <= nr < N and 0 <= nc < M:
            if visited[nr][nc]:
                continue
            if arr[nr][nc]:
                dfs(nr, nc)


T = int(input())

for t in range(1, T + 1):
    M, N, K = map(int, input().split())  # 가로, 세로, 배추개수
    arr = [[0] * M for _ in range(N)]
    visited = [[0] * M for _ in range(N)]

    # arr입력!
    for _ in range(K):
        c, r = map(int, input().split())
        arr[r][c] = 1

    # 로직 시작!
    ans = 0
    for r in range(N):
        for c in range(M):
            if arr[r][c] and not visited[r][c]:
                dfs(r, c)
                ans += 1

    print(ans)
