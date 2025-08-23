# 시작시간 : 1시 47분

# n 5000 -> n^2이면 시간 아슬아슬
# 그래도 그냥 완탐 해보자

N, K = map(int, input().split())

lst = [i for i in range(1, N + 1)]
ans = []

idx = 0

while lst:
    idx = (idx + K - 1) % len(lst)
    ans.append(lst[idx])
    del lst[idx]

anss = ', '.join(list(map(str, ans)))

print('<' + anss + '>')