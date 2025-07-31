# 풀이 : 11시 3분 ~ 11시 14분
# 소요시간 : 11분
from collections import deque

M, N = map(int, input().split())

arr = [list(map(int, input().split())) for _ in range(N)]
zero_count = 0  # 익혀야하는 토마토 수
# visited는 사용하지 않고 map을 1로 바꿀 예정

queue = deque([])
for r in range(N):
    for c in range(M):
        if arr[r][c] == 1:
            queue.appendleft((r, c))
        if arr[r][c] == 0:
            zero_count += 1
cnt = 0
day = -1
while queue:
    day+=1
    size = len(queue)
    for _ in range(size):    # day일차의 토마토 다 꺼내서 익히기
        cr, cc = queue.pop()
        for dr, dc in ((-1, 0), (1, 0), (0, 1), (0, -1)):
            nr, nc = cr + dr, cc + dc
            if 0 <= nr < N and 0 <= nc < M:
                if arr[nr][nc] == 0:    # 안익은 토마토이면
                    queue.appendleft((nr, nc))
                    arr[nr][nc] = 1 # 익은 토마토로 변경(visited처리)
                    cnt += 1    #다 익었는지 확인하기 위함
if cnt == zero_count:
    print(day)
else:
    print(-1)