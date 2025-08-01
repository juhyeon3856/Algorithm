# 시작시간 10시 15분
# 제출시간 10시 46분
# 소요시간 31분(디버깅 4분)

from collections import deque

N, M = 10, 9

dr = [-3, -3, -2, 2, 3, 3, 2, -2]
dc = [-2, 2, 3, 3, 2, -2, -3, -3]

_dr = [[-1, -2], [-1, -2], [0, -1], [0, 1], [1, 2], [1, 2], [0, 1], [0, -1]]
_dc = [[0, -1], [0, 1], [1, 2], [1, 2], [0, 1], [0, -1], [-1, -2], [-1, -2]]

sr, sc = map(int, input().split())
er, ec = map(int, input().split())
visited = [[0] * M for _ in range(N)]

queue = deque([(sr, sc)])
visited[sr][sc] = 1

ans = -1
while queue:
    cr, cc = queue.popleft()
    if (cr, cc) == (er, ec):
        ans = visited[cr][cc] - 1
        break
    for d in range(8):
        nr, nc = cr + dr[d], cc + dc[d]
        if 0 > nr or nr >= N or 0 > nc or nc >= M:  # 범위 밖이면
            continue
        if visited[nr][nc]:  # 이미 방문 했으면
            continue

        # 가는길에 있는지 확인
        _nr, _nc = cr + _dr[d][0], cc + _dc[d][0]
        if (_nr, _nc) == (er, ec):
            continue
        _nr, _nc = cr + _dr[d][1], cc + _dc[d][1]
        if (_nr, _nc) == (er, ec):
            continue

        queue.append((nr, nc))
        visited[nr][nc] = visited[cr][cc] + 1

print(ans)