from collections import deque

N, M, K = map(int, input().split())
er, ec = N - 1, (2 * (M - 1)) + ((N - 1) % 2)
M = M * 2

arr = [list(map(int, input().split())) for _ in range(K)]

dr = [-1, -1, 0, 1, 1, 0]
dc = [-1, 1, 2, 1, -1, -2]

visited = [[0] * M for _ in range(N)]

for r, c in arr:
    visited[r][(c * 2) + (r % 2)] = -1  # 장애물 있음


def check(r, c):
    return 0 <= r < N and 0 <= c < M


queue = deque([(0, 0)])
visited[0][0] = 1

ans = -1
while queue:
    cr, cc = queue.popleft()

    # 정답
    if (cr, cc) == (er, ec):
        ans = visited[cr][cc] - 1
        break

    # nr찾아서
    for d in range(6):
        nr, nc = cr + dr[d], cc + dc[d]

        if not check(nr, nc):
            continue

        if visited[nr][nc]:
            continue

        queue.append((nr, nc))
        visited[nr][nc] = visited[cr][cc] + 1

print(ans)