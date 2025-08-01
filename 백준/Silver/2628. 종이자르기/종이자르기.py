# 시작시간 10시 5분
# 제출시간 10시 13분
# 소요시간 8분

# 아이디어
# 가로로 자른거 sort, 세로로 자른거 sort
# 그 후 사이 간격 중 가장 큰 값 찾음

W, H = map(int, input().split())
N = int(input())

wlst = [0, W]   # 세로로 자른 것, 1으로 시작
hlst = [0, H]       # 가로로 자른 것, 0로 시작

for _ in range(N):
    t, i = map(int, input().split())
    if t == 1:
        wlst.append(i)
    elif t == 0:
        hlst.append(i)

wlst.sort()
hlst.sort()

wlen = []   # 가로 길이들
hlen = []   # 세로 길이들
for i in range(1, len(wlst)):
    wlen.append(wlst[i] - wlst[i-1])
for i in range(1, len(hlst)):
    hlen.append(hlst[i] - hlst[i-1])

print(max(wlen) * max(hlen))


