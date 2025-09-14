from collections import deque

# 입력
N, M = map(int, input().split())

adj = [[0] * N for _ in range(N)]

# 불 켤 수 있는 장소 저장
for _ in range(M):
    sr, sc, er, ec = map(lambda x: int(x) - 1, input().split())
    adj[sr][sc] |= 1 << (er * N + ec)

# 전처리
dr = [-1, 1, 0, 0]
dc = [0, 0, 1, -1]

visited = [[0] * N for _ in range(N)]
queue = deque()
nq = deque()


def check(fr, fc):
    return 0 <= fr < N and 0 <= fc < N


nq.append((0, 0))  # r, c, light
visited[0][0] = 1

cur_key = 1 | adj[0][0]
time = 1
while queue or nq:
    time += 1
    queue = nq
    nq = deque()
    is_end = True
    while queue:
        cr, cc = queue.popleft()

        if cur_key & (1 << (cr * N + cc)) == 0:  # 못가면 nq에 넣음
            nq.append((cr, cc))
            visited[cr][cc] = time
            continue

        # 갈수있으면
        is_end = False
        for d in range(4):
            nr, nc = cr + dr[d], cc + dc[d]

            if not check(nr, nc):  # 범위 밖이면
                continue

            if visited[nr][nc] == time:  # 이미 방문했으면
                continue

            if cur_key & (1 << (nr * N + nc)) == 0:  # 불 켜진곳이 아니면
                nq.append((nr, nc))
                visited[nr][nc] = time
                continue

            cur_key = cur_key | adj[nr][nc]

            visited[nr][nc] = time
            queue.append((nr, nc))

    if is_end:
        break

ans = 0
ans_bit = cur_key
for _ in range(N * N):
    if ans_bit & 1 == 1:
        ans += 1
    ans_bit >>= 1

print(ans)
