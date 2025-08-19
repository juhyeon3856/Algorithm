# 입력
N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

# 전처리
ans = []  # 정답 붙이기

debug = 0  # visited 잘 만들어졌는지 확인

# 상우하좌
dr = [-1, 0, 1, 0]
dc = [0, 1, 0, -1]


# 로직
def is_ans(fr, fc, dir):  # 별을 가둘 수 있는지 확인
    while 0 <= fr < N and 0 <= fc < M:  # 범위 내에 있는 동안
        if visited[fr][fc][dir]:
            return True  # 같은 장소에 같은 방향으로 왔다는 것은 정답이 될 수 있다는 의미

        visited[fr][fc][dir] = 1
        fr, fc, dir = fr + dr[dir] * arr[fr][fc], fc + dc[dir] * arr[fr][fc], (dir + 1) % 4
    return False


for cr in range(N):
    debug = 1  # cr잘 들어오는지 확인

    visited = [[[0] * 4 for _ in range(M)] for _ in range(N)]  # visited[r][c][dir]

    if is_ans(cr, 0, 1):  # (cr, 0)에서 우측 방향
        ans.append(cr + 1)  # 0인덱스->1인덱스

# 정답 출력
print(len(ans))
print(*ans, sep=' ')