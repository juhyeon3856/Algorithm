'''체크리스트
행과 열은 1번부터 N번까지 번호가 매겨져 있
1번 행은 N번과 연결되어 있고, 1번 열은 N번 열과 연결(도넛)
'''

N, M, K = map(int, input().split())

dr = [-1, -1, 0, 1, 1, 1, 0, -1]
dc = [0, 1, 1, 1, 0, -1, -1, -1]


class Fire_Node:
    # 위치, 질량,속력,  방향
    def __init__(self, r, c, m, s, d):
        self.id = r * N + c
        self.r = r
        self.c = c
        self.m = m
        self.s = s
        self.d = d

    def __repr__(self):
        return f"{self.m, self.s, self.d}"
        # return f"r: {self.r}, c: {self.c}, m: {self.m}, s: {self.s}, d: {self.d}"

    def move(self):
        self.r = (self.r + (dr[self.d] * self.s)) % N
        self.c = (self.c + (dc[self.d] * self.s)) % N


# test!!!
# test_map = [[0] * 5 for _ in range(5)]
# ffire = Fire_Node(2, 2, 9, 2, 6)
# test_map[2][2] = 1
# ffire.move()
# test_map[ffire.r][ffire.c] = 2
# debug = 0

arr = [[[] for _ in range(N)] for _ in range(N)]

for _ in range(M):
    r, c, m, s, d = map(int, input().split())
    arr[r - 1][c - 1].append(Fire_Node(r - 1, c - 1, m, s, d))

debug = 0  # arr 확인


def move_fires():
    new_arr = [[[] for _ in range(N)] for _ in range(N)]
    for r in range(N):
        for c in range(N):
            for fire in arr[r][c]:
                # print(fire.r, fire.c, fire.m, fire.s, fire.d)
                # print(fire)
                fire.move()
                new_arr[fire.r][fire.c].append(fire)
    return new_arr


def sum_fires():
    for r in range(N):
        for c in range(N):
            if len(arr[r][c]) > 1:  # 2개 이상이면
                sum_fire(r, c)


def sum_fire(r, c):
    sm, ss, even, odd = 0, 0, 0, 0  # 질량, 속도 합, 짝수방향수, 홀수방향수
    for fire in arr[r][c]:
        sm += fire.m
        ss += fire.s
        if fire.d % 2 == 0:
            even += 1
        else:
            odd += 1
    nm, ns = sm // 5, ss // len(arr[r][c])  # 양수니까 //괜춘할듯

    if nm == 0:  # 질량이 0인 파이어볼은 소멸되어 없어진다.
        arr[r][c] = []
        return

    new_arr_r_c = []
    if even and odd:  # 둘 다 있으면
        for d in (1, 3, 5, 7):
            new_arr_r_c.append(Fire_Node(r, c, nm, ns, d))
    else:  # 합쳐지는 파이어볼의 방향이 모두 홀수이거나 모두 짝수이면
        for d in (0, 2, 4, 6):
            new_arr_r_c.append(Fire_Node(r, c, nm, ns, d))
    arr[r][c] = new_arr_r_c


def print_arr():
    for lst in arr:
        print(*lst)
    print("---------------")


# 상어가 명령 함
# print_arr()
for _ in range(K):
    # 이동
    arr = move_fires()
    # print_arr()

    # 같은 칸에 있는 파이어볼은 모두 하나로 합쳐
    # 질량이 0인 파이어볼은 소멸되어 없어진다.
    sum_fires()
    # print_arr()
    # print()

# 정답 구하기
ans = 0
for r in range(N):
    for c in range(N):
        for f in arr[r][c]:
            ans += f.m

print(ans)