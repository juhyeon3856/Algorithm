# 시작시간 : 14시 43분
# 제출시간 : 15시 4분
# 제출횟수 : 1회


# 입력받기 #################################
N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

# 치킨 및 집의 인덱스 뽑기 #######################
chicken = []
home = []

for r in range(N):
    for c in range(N):
        if arr[r][c] == 1:
            home.append((r, c))
        elif arr[r][c] == 2:
            chicken.append((r, c))

C, H = len(chicken), len(home)


# 치킨집과 집 사이 거리행렬 만들기 ##########################
def clac_dist(ci, hi):
    return abs(chicken[ci][0] - home[hi][1])


dist = [[0] * H for i in range(C)]  # 행 : 치킨, 열: 집
for r in range(C):
    for c in range(H):
        dist[r][c] = abs(chicken[r][0] - home[c][0]) + abs(chicken[r][1] - home[c][1])  # ci번쨰 치킨집과 hi번쨰 집의 거리


# 치킨집 C개 중 M개 뽑기
def combi(depth, start):
    if depth == M:  # 종료조건
        ans[0] = min(ans[0], calc_city_dist())  # 정답 갱신
        return
    for i in range(start, C):
        nums[depth] = i
        combi(depth + 1, i + 1)


# M개를 선택했을 떄 도시의 치킨거리
def calc_city_dist():
    result = 0  # 도시의 치킨 거리
    for i in range(H):
        mn = 1000000  # i번쨰 집의 치킨 거리(최대 100)
        for n in nums:
            mn = min(mn, dist[n][i])
        result += mn
    return result


ans = [10000000000]  # 예상 최대 100 * 100
nums = [0] * M
combi(0, 0)
print(ans[0])