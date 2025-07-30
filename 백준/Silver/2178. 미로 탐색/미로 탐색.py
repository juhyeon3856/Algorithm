# 아이디어
# bfs거리 계산
# 1은 이동할 수 있는 칸
# 0은 이동할 수 없는 칸

N, M = map(int, input().split())
arr = [[0] * (M + 2)] + [[0] + list(map(int, input())) + [0] for _ in range(N)] + [[0] * (M + 2)]
visited = [[0] * (M+2) for _ in range(N+2)]

ans = 0

dr = [-1, 1, 0, 0]
dc = [0, 0, 1, -1]

# 입력 완료! 로직 시작
from collections import deque

queue = deque([[1, 1]])
visited[1][1] = 1

while queue:
    q = queue.pop()
    cr, cc = q[0], q[1]
    for d in range(4):
        nr, nc = cr + dr[d], cc + dc[d]
        if nr == N and nc == M:
            ans = visited[cr][cc] + 1
            queue.clear()
            break
        if visited[nr][nc]:
            continue
        if not arr[nr][nc]:  # 이동할 수 없는 칸이면
            continue
        visited[nr][nc] = visited[cr][cc] + 1
        queue.appendleft([nr, nc])

print(ans)