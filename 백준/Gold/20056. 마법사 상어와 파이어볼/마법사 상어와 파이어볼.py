# 함수들 ----------------------------------------------
class Fire:
    def __init__(self, m, s, d):
        self.m = m
        self.s = s
        self.d = d

    def __repr__(self):
        return f"{self.m}"


def move():
    new_arr = [[[] for _ in range(N)] for _ in range(N)]
    for r in range(N):
        for c in range(N):
            for fire in arr[r][c]:
                nr, nc = (r + fire.s * dr[fire.d]) % N, (c + fire.s * dc[fire.d]) % N
                new_arr[nr][nc].append(fire)
    return new_arr


def merge():
    # new_arr = [[[] for _ in range(N)] for _ in range(N)]
    for r in range(N):
        for c in range(N):
            if len(arr[r][c]) <= 1:  # 그대로
                continue
            # 합쳐지기
            summ, sums, cntd = 0, 0, [0, 0]
            llen = len(arr[r][c])
            for fire in arr[r][c]:
                summ += fire.m
                sums += fire.s
                cntd[fire.d % 2] += 1

            arr[r][c] = []

            if summ // 5 == 0:
                continue

            if cntd[0] * cntd[1] == 0:  # 둘 중 하나라도 0이면
                for d in (0, 2, 4, 6):
                    arr[r][c].append(Fire(summ // 5, sums // llen, d))
            else:
                for d in (1, 3, 5, 7):
                    arr[r][c].append(Fire(summ // 5, sums // llen, d))


# 입력 및 전처리 ----------------------------------------
N, M, K = map(int, input().split())
arr = [[[] for _ in range(N)] for _ in range(N)]
for _ in range(M):
    ir, ic, im, iis, iid = map(int, input().split())
    arr[ir - 1][ic - 1].append(Fire(im, iis, iid))

dr = [-1, -1, 0, 1, 1, 1, 0, -1]
dc = [0, 1, 1, 1, 0, -1, -1, -1]

# 로직 ------------------------------------------------
for time in range(1, K + 1):
    arr = move()
    merge()

# 정답 ------------------------------------------------
ans = 0
for r in range(N):
    for c in range(N):
        for fire in arr[r][c]:
            ans += fire.m
print(ans)
