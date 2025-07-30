# 아이디어
# bfs거리 계산
# 나이트로 시작점에서 목표점까지 최단 거리 구하기

from collections import deque

dr = [-2, -1, 1, 2, 2, 1, -1, -2]
dc = [1, 2, 2, 1, -1, -2, -2, -1]

T = int(input())
for t in range(1, T + 1):
    N = int(input())
    sr, sc = map(int, input().split())  # 시작점
    er, ec = map(int, input().split())  # 목표점

    visited = [[0] * N for _ in range(N)]  # 방문 처리 및 이동 횟수 저장

    queue = deque([[sr, sc]])
    visited[sr][sc] = 1

    while queue:
        q = queue.pop()
        cr, cc = q[0], q[1]
        if cr == er and cc == ec:  # 도착했으면
            break  # while탈출!
        for d in range(8):
            nr, nc = cr + dr[d], cc + dc[d]
            if 0 <= nr < N and 0 <= nc < N:
                if visited[nr][nc]:  # 이미 방문했으면
                    continue  # skip
                queue.appendleft([nr, nc])
                visited[nr][nc] = visited[cr][cc] + 1

    print(visited[er][ec] - 1 )