TC = int(input())
from collections import deque

blank = '.'
goal = '$'
wall = '*'
queue = deque()

dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]


def check(r, c):
    return 0 <= nr < N + 2 and 0 <= nc < M + 2


big = 'QWERTYUIOPASDFGHJKLZXCVBNM'
small = 'qwertyuiopasdfghjklzxcvbnm'
# print(len(big))
# print(len(small))

for tc in range(1, TC + 1):
    N, M = map(int, input().split())
    arr = [[blank] * (M + 2)] + [[blank] + list(input()) + [blank] for _ in range(N)] + [[blank] * (M + 2)]
    keys = input()
    keys = '' if keys == '0' else keys
    ans = 0

    visited = [[0] * (M + 2) for _ in range(N + 2)]
    queue.append((0, 0))
    visited[0][0] = 1
    time = 1
    close_door = []
    while queue:

        while queue:
            cr, cc = queue.popleft()
            for d in range(4):
                nr, nc = cr + dr[d], cc + dc[d]
                if not check(nr, nc):
                    continue
                if visited[nr][nc] != 0:
                    continue
                if arr[nr][nc] == wall:
                    continue
                if arr[nr][nc] == goal:
                    ans += 1
                    arr[nr][nc] = blank
                if arr[nr][nc] in big:
                    if arr[nr][nc].lower() not in keys:
                        close_door.append((arr[nr][nc], nr, nc))
                        continue
                if arr[nr][nc] in small:
                    if arr[nr][nc] not in keys:
                        keys += arr[nr][nc]
                    arr[nr][nc] = blank

                visited[nr][nc] = time
                queue.append((nr, nc))

        for door, ddr, ddc in close_door:
            if visited[ddr][ddc] != 0:
                continue
            if door.lower() in keys:
                visited[ddr][ddc] = time
                queue.append((ddr, ddc))

        time += 1

    print(ans)
