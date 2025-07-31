# 풀이 : 11시 20분 ~ 11시 31분 / 11시 40분 ~ 11시 41분
# 풀이시간 : 12분
from collections import deque


def bfs(fr, fc, arr, visited):
    queue = deque([(fr, fc)])
    visited[fr][fc] = 1
    while queue:
        cr, cc = queue.pop()
        for dr, dc in ((-1, 0), (1, 0), (0, -1), (0, 1)):
            nr, nc = cr + dr, cc + dc
            if 0 <= nr < N and 0 <= nc < N:
                if visited[nr][nc]:  # 이미 방문했으면
                    continue
                if arr[fr][fc] != arr[nr][nc]:  # 시작과 다른 색상이면
                    continue
                visited[nr][nc] = 1
                queue.appendleft((nr, nc))


N = int(input())
arr1 = []
arr2 = []

for _ in range(N):
    st = input()
    arr1.append(list(st))
    st = st.replace('R', 'G')
    arr2.append(list(st))

visited1 = [[0] * N for _ in range(N)]
visited2 = [[0] * N for _ in range(N)]

ans1 = ans2 = 0

for r in range(N):
    for c in range(N):
        if not visited1[r][c]:
            bfs(r, c, arr1, visited1)
            ans1 += 1
        if not visited2[r][c]:
            bfs(r, c, arr2, visited2)
            ans2 += 1

print(ans1, ans2)