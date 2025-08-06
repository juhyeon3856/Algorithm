# 집에서 가장 가까운 대피소로 이동할 때 가장 긴 거리가 최소가 되도록
# 대피소와 가장 멀리 떨어진 집과의 거리를 구하려고 한다.

N, K = map(int, input().split())
# x. y
arr = [list(map(int, input().split())) for _ in range(N)]
dist = [[0] * N for _ in range(N)]  # r부터 c까지 거리 배열
for r in range(N):
    for c in range(N):
        dd = abs(arr[r][0] - arr[c][0]) + abs(arr[r][1] - arr[c][1])
        dist[r][c] = dd
        dist[c][r] = dd  # 혹시나


## 입력 완료! 로직 시작

def combi(depth, start):
    if depth == K:
        ans[0] = min(ans[0], basecondition())
        return
    for i in range(start, N):
        nums[depth] = i
        combi(depth + 1, i + 1)


def basecondition():
    mx = 0
    for n in range(N):
        mn = 100000000
        for k in range(K):  # 대피소 중 가장 짧은 거 구함
            mn = min(mn, dist[nums[k]][n])
        mx = max(mx, mn)
    return mx


ans = [100000000]
nums = [0] * K
combi(0, 0)
print(ans[0])