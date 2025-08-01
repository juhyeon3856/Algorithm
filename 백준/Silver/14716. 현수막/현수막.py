# 상, 하, 좌, 우, 대각선
from collections import deque


def bfs(fr, fc):
    queue = deque([(fr, fc)])
    visited[fr][fc] = 1

    while queue:
        cr, cc = queue.popleft()
        for d in range(8):
            nr, nc = cr + dr[d], cc + dc[d]
            if 0 <= nr < N and 0 <= nc < M:
                if arr[nr][nc] == 0:
                    continue
                if visited[nr][nc]:
                    continue
                queue.append([nr, nc])
                visited[nr][nc] = 1


N, M = map(int, input().split())

arr = [list(map(int, input().split())) for _ in range(N)]
visited = [[0] * M for _ in range(N)]

# 8방향
dr = [-1, -1, 0, 1, 1, 1, 0, -1]
dc = [0, 1, 1, 1, 0, -1, -1, -1]
ans = 0

for r in range(N):
    for c in range(M):
        if arr[r][c] == 0:
            continue
        if visited[r][c]:  # 방문했으면
            continue
        ans += 1
        bfs(r, c)

print(ans)
