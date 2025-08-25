# 계란 틀 분리

# 계란틀 평균내기

from collections import deque

dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]


def bfs(r, c, ttype):
    queue = deque([(r, c)])
    visited[r][c] = ttype
    cnt = 1
    sm = arr[r][c]

    while queue:
        cr, cc = queue.popleft()

        for d in range(4):
            nr, nc = cr + dr[d], cc + dc[d]

            if not (0 <= nr < N and 0 <= nc < N):
                continue

            if visited[nr][nc]:  # 이미 그룹 있으면
                continue

            if L <= abs(arr[cr][cc] - arr[nr][nc]) <= R:
                queue.append((nr, nc))
                visited[nr][nc] = ttype
                sm += arr[nr][nc]
                cnt += 1
    return sm, cnt


# 입력
N, L, R = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

ans = 0

while True:
    avg_lst = [0] 

    visited = [[0] * N for _ in range(N)]

    # 그룹 나누기
    for r in range(N):
        for c in range(N):
            if visited[r][c] == 0:  # 그룹 아직 없으면
                _sum, _cnt = bfs(r, c, len(avg_lst))  # r, c에서 len(avg_lst)번쨰 그룹 만들기
                avg_lst.append(_sum // _cnt)

    # 더이상 변화가 없으면 -> 각자 그룹인 경우
    if len(avg_lst) == (N * N + 1):
        break

    # 값 갱신하기
    for r in range(N):
        for c in range(N):
            arr[r][c] = avg_lst[visited[r][c]]

    ans += 1

print(ans)