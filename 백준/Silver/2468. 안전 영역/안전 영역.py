# 시작시간 : 9시 40분
# 끝난시간 : 9시 58분
# 소요시간 : 18분

# 일정한 높이 이하의 모든 지점은 물에 잠긴

from collections import deque


def bfs(fr, fc, fh):
    queue = deque([(fr, fc)])
    visited[fr][fc] = fh

    while queue:
        cr, cc = queue.pop()
        for dr, dc in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
            nr, nc = cr + dr, cc + dc
            if 0 <= nr < N and 0 <= nc < N:
                if arr[nr][nc] <= fh:  # 잠긴 영역이면
                    continue
                if visited[nr][nc] == fh:
                    continue
                visited[nr][nc] = fh
                queue.append((nr, nc))


def count_area(fh):
    result = 0
    for r in range(N):
        for c in range(N):
            if arr[r][c] <= fh:  # 잠기지 않으면
                continue
            if visited[r][c] == fh:  # 이미 방문 했으면
                continue
            bfs(r, c, fh)
            result += 1
    return result


N = int(input())

arr = [list(map(int, input().split())) for _ in range(N)]

mx = max(sum(arr, []))
mn = min(sum(arr, []))

visited = [[0] * N for _ in range(N)]

ans = 1  # 안전영역 최소 1개
for h in range(mn, mx):  # mx 는 다 잠기니까 안해도 고려 X
    ans = max(ans, count_area(h))

print(ans)
