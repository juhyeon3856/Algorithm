# 7시 9분

# 참고로 말은 장애물을 뛰어넘을 수 있다.
#  총 K번만 위와 같이 움직일 수 있고,

# 아이디어 : 3차원 visited & bfs
from collections import deque

# 입력
K = int(input())
M, N = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

# 전처리
dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

debug_arr = [[0] * 5 for _ in range(5)]
for d in range(4):
    debug_arr[2 + dr[d]][2 + dc[d]] += 1
debug = 0  # debug_arr

hdr = [-2, -1, 1, 2, 2, 1, -1, -2]
hdc = [1, 2, 2, 1, -1, -2, -2, -1]

debug_arr = [[0] * 5 for _ in range(5)]
for d in range(8):
    debug_arr[2 + hdr[d]][2 + hdc[d]] += 1
debug = 1  # debug_arr

visited = [[[0] * (K + 1) for _ in range(M)] for _ in range(N)]

debug = 2  # visited확인

er, ec = N - 1, M - 1


# 로직 bfs

def check(fr, fc):
    return 0 <= fr < N and 0 <= fc < M


# 초기화
queue = deque([(0, 0, 0)])
visited[0][0][0] = 1

ans = -1
while queue:
    cr, cc, ck = queue.popleft()

    # 정답 체크
    if (cr, cc) == (er, ec):
        ans = visited[cr][cc][ck] - 1
        break

    # 원숭이 이동
    for d in range(4):
        nr, nc, nk = cr + dr[d], cc + dc[d], ck

        if not check(nr, nc):  # 범위
            continue

        if arr[nr][nc]:  # 장애물이면
            continue

        if visited[nr][nc][nk]:  # 이미 방문했으면
            continue

        queue.append((nr, nc, nk))
        visited[nr][nc][nk] = visited[cr][cc][ck] + 1

    # 말이동
    if ck < K:  # 말 이동 가능하면
        for d in range(8):
            nr, nc, nk = cr + hdr[d], cc + hdc[d], ck + 1

            if not check(nr, nc):  # 범위
                continue

            if arr[nr][nc]:  # 장애물이면
                continue

            if visited[nr][nc][nk]:  # 이미 방문했으면
                continue

            queue.append((nr, nc, nk))
            visited[nr][nc][nk] = visited[cr][cc][ck] + 1

print(ans)