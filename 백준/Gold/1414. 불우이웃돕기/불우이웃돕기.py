# 입력
N = int(input())

input_arr = [list(input()) for _ in range(N)]

arr = [[0] * N for _ in range(N)]
tot = 0

for r in range(N):
    for c in range(N):
        data = input_arr[r][c]
        if 'A' <= data <= 'Z':
            arr[r][c] = 27 + ord(data) - 65
        elif 'a' <= data <= 'z':
            arr[r][c] = 1 + ord(data) - 97
        else:
            arr[r][c] = 0
        tot += arr[r][c]

# 입력완료 로직 시작!
# 프림
from heapq import heappop, heappush

visited = [0] * N
use = 0
cnt = 0

pq = [(0, 0)]  # w, idx
ans = -1

while pq:
    cw, ci = heappop(pq)

    if visited[ci]:
        continue
    visited[ci] = 1
    cnt += 1
    use += cw

    if cnt == N:
        ans = tot - use
        break

    for ni in range(N):
        if arr[ci][ni]:
            heappush(pq, (arr[ci][ni], ni))
        if arr[ni][ci]:
            heappush(pq, (arr[ni][ci], ni))

print(ans)