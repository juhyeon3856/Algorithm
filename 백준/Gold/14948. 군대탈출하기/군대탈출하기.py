# 이분탐색 + bfs
from collections import deque

N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

dr = [-1, 1, 0, 0]
dc = [0, 0, 1, -1]


def check(fr, fc):
    return 0 <= fr < N and 0 <= fc < M


def bfs(num):  # num으로 갈 수 있는지
    if arr[0][0] > num:
        return False

    visited = [[[0] * M for _ in range(N)] for _ in range(2)]
    queue = deque()

    queue.append((0, 0, 0))
    visited[0][0][0] = 1  # 점프 한번도 안하고

    while queue:
        cr, cc, ck = queue.popleft()

        if (cr, cc) == (N - 1, M - 1):
            return True

        for d in range(4):
            nr, nc = cr + dr[d], cc + dc[d]

            if not check(nr, nc):
                continue

            if visited[ck][nr][nc] == 1:
                continue

            if arr[nr][nc] > num:
                continue

            queue.append((nr, nc, ck))
            visited[ck][nr][nc] = 1

        # 한칸 건너뛰기
        if ck == 0:
            for d in range(4):
                nr, nc = cr + dr[d] * 2, cc + dc[d] * 2

                if not check(nr, nc):
                    continue

                if visited[ck + 1][nr][nc] == 1:
                    continue

                if arr[nr][nc] > num:
                    continue

                queue.append((nr, nc, ck + 1))
                visited[ck + 1][nr][nc] = 1

    return False


def search():
    s, e = 0, 10 ** 9 + 1
    result = 10 ** 9

    while s < e:
        mid = (s + e) // 2

        if bfs(mid):
            result = mid
            e = mid
        else:
            s = mid + 1

    return result


print(search())
