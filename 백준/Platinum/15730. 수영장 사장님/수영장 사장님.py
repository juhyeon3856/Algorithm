from collections import deque

N, M = map(int, input().split())
bottom_arr = [list(map(int, input().split())) for _ in range(N)]

fill_arr = [[-1] * M for _ in range(N)]

dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]


def check(fr, fc):
    return 0 <= fr < N and 0 <= fc < M


def bfs(r, c, num):
    queue = deque()
    visited = [[0] * M for _ in range(N)]

    queue.append((r, c))
    visited[r][c] = 1

    while queue:
        cr, cc = queue.popleft()
        for d in range(4):
            nr, nc = cr + dr[d], cc + dc[d]
            if not check(nr, nc):
                return 0  # false리턴 -> 그 물로 채웠을때 새어나간다
            if visited[nr][nc] == 1:
                continue
            if bottom_arr[nr][nc] >= num:  # 이동 못함
                continue
            queue.append((nr, nc))
            visited[nr][nc] = 1
    return True


def search(r, c):
    fill_arr[r][c] = -1
    s, e = 0, 10001
    while s < e:
        mid = (s + e) // 2
        if bfs(r, c, mid):  # mid이상 벽 -> 미만으로만 이동해서 oob나면 false 안나면 true
            s = mid + 1
            fill_arr[r][c] = mid
        else:
            e = mid


for rr in range(N):
    for cc in range(M):
        search(rr, cc)

# 정답처리
ans = 0
for rr in range(N):
    for cc in range(M):
        ans += max(0, fill_arr[rr][cc] - bottom_arr[rr][cc])
print(ans)