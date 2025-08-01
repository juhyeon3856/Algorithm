from collections import deque

dr = [-1, 1, 0, 0]
dc = [0, 0, 1, -1]


def bfs(fr, fc):
    queue = deque([(fr, fc)])
    visited[fr][fc] = 1

    while queue:
        cr, cc = queue.popleft()
        for d in range(4):
            nr, nc = (cr + dr[d] + N) % N, (cc + dc[d] + M) % M
            if arr[nr][nc] == 1:  # 숲이면
                continue
            if visited[nr][nc]:  # 갔으면
                continue
            queue.append([nr, nc])
            visited[nr][nc] = 1


N, M = map(int, input().split())

arr = [list(map(int, input().split())) for _ in range(N)]
visited = [[0] * M for _ in range(N)]

cnt = 0
for r in range(N):
    for c in range(M):
        if arr[r][c] == 1:  # 못가면
            continue
        if visited[r][c]:  # 방문했으면
            continue
        bfs(r, c)
        cnt += 1

print(cnt)