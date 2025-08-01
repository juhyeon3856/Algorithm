N, L = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

arr.sort()
time = 0
cur = 0

for d, r, g in arr:
    _time = time + d - cur  # 도착시간
    q = _time // (r + g)  # 이전까지 반복시간
    red_time = q * (r + g) + r
    time = max(red_time, _time)
    cur = d


time += L - cur

print(time)