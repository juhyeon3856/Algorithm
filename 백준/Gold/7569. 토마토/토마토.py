# 시작시간 9시 15분
# 제출시간 9시 30분
# 소요시간 15분

from collections import deque

M, N, H = map(int, input().split())

arr = [[list(map(int, input().split())) for _ in range(N)] for _ in range(H)]

queue = deque([])
visited = [[[0] * M for _ in range(N)] for _ in range(H)]
zero_cnt = 0
for z in range(H):
    for r in range(N):
        for c in range(M):
            if arr[z][r][c] == 1:
                queue.append([z, r, c]) # 익은 토마토 넣기
            elif arr[z][r][c] == 0:
                zero_cnt += 1           # 익혀야 하는 토마토 수

# 입력 완료 로직 시작!

dr = [1, -1, 0, 0, 0, 0]
dc = [0, 0, 1, -1, 0, 0]
dz = [0, 0, 0, 0, 1, -1]

cnt = 0 # 실제로 익힌 토마토 수
day = -1
while queue:
    size = len(queue)
    day += 1
    for _ in range(size):   # 하루치 queue에 들어있는거 다 빼기
        cz, cr, cc = queue.popleft()
        for d in range(6):
            nz, nr, nc = cz + dz[d], cr + dr[d], cc + dc[d]
            if 0<=nz<H and 0<=nr<N and 0<=nc<M: #범위 내
                if arr[nz][nr][nc] == 0:    # 익혀야하는 토마토이면
                    queue.append(([nz, nr, nc]))
                    arr[nz][nr][nc] = 1     # visited대신 1로 바꾸기
                    cnt += 1                # 실제로 바꾼 토마토수 갱신
            
if cnt == zero_cnt: # 실제 익힌 수 == 익혀야하는 수
    print(day)  # 다익힘
else:   # 덜익힘
    print(-1)