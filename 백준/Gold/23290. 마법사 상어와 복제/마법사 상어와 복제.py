# 입력 -----------------------------------------------
N = 4
M, S = map(int, input().split())

arr = [[[] for _ in range(N)] for _ in range(N)]
for _ in range(M):
    fx, fy, d = map(int, input().split())
    arr[fx - 1][fy - 1].append(d - 1)

sr, sc = map(lambda x: int(x) - 1, input().split())  # 상어

# 전처리 ----------------------------------------------
dr = [0, -1, -1, -1, 0, 1, 1, 1]
dc = [-1, -1, 0, 1, 1, 1, 0, -1]
ds = ['←', '↖', '↑', '↗', '→', '↘', '↓', '↙']

sdr = [-1, 0, 1, 0]
sdc = [0, -1, 0, 1]
sds = ['↑', '←', '↓', '→']

btk_nums = [-1, -1, -1]
max_nums = [-1, -1, -1]
max_tot = [-1]

smell_arr = [[0] * N for _ in range(N)]


# 함수 ------------------------------------------------
def print_info():
    # print("=============================")
    # print_arr()
    # print("------------------------------")
    # print_smell()
    # print()
    return


def print_arr():
    for r in range(N):
        for c in range(N):

            ccc = 0
            for d in arr[r][c]:
                print(f"{ds[d]}", end='')
                ccc += 1
            for _ in range(ccc, 10):
                print(" ", end="")
            print('|\t', end="")
        print()


def print_smell():
    for r in range(N):
        for c in range(N):
            if (r, c) == (sr, sc):
                print('S', end='')
            if smell_arr[r][c] == time + 1:
                print(1, end="\t")
            elif smell_arr[r][c] == time + 2:
                print(2, end="\t")
            elif smell_arr[r][c] == time:
                print(9, end="\t")
            else:
                print(0, end="\t")
        print()


def check(fr, fc):
    return 0 <= fr < N and 0 <= fc < N


# 반시계 회전하는데 언제 멈춰야하지?
# 이런 경우 없음 -> 최소 이동 장소 3곳 -> 갈수없는곳 최대 2개
def move_fish():
    new_arr = [[[] for _ in range(N)] for _ in range(N)]
    for cr in range(N):
        for cc in range(N):
            for cd in arr[cr][cc]:
                for dd in range(8):  # 반시계 8방향
                    nr, nc = cr + dr[(cd - dd) % 8], cc + dc[(cd - dd) % 8]
                    if not check(nr, nc):  # 범위
                        continue
                    if (nr, nc) == (sr, sc):  # 상어이면
                        continue
                    if smell_arr[nr][nc] >= time:  # 냄새 남아있음
                        continue

                    # 이동 가능한 경우
                    new_arr[nr][nc].append((cd - dd) % 8)
                    break
                else:  # 아래 둘 중 뭘까
                    new_arr[cr][cc].append(cd)
                    # new_arr[cr][cc].append((cd + 1) % 8)
                    # print("NOOOOOOOOOOOOOOOOOOOOO")
    return new_arr


def find_move_type(depth, tot, cr, cc):  # 백트래킹
    if depth == 3:
        debug = 0  # 오는 순서 확인
        if tot > max_tot[0]:  # 클떄만 갱신
            max_tot[0] = tot
            max_nums[0], max_nums[1], max_nums[2] = btk_nums[0], btk_nums[1], btk_nums[2]
        return

    for di in range(4):
        nr, nc = cr + sdr[di], cc + sdc[di]
        if not check(nr, nc):
            continue
        btk_nums[depth] = di
        temp = arr[nr][nc]
        arr[nr][nc] = []
        find_move_type(depth + 1, tot + len(temp), nr, nc)
        arr[nr][nc] = temp


def move_shark():
    global sr, sc
    # btk_nums[0], btk_nums[1], btk_nums[2] = -1, -1, -1
    max_nums[0], max_nums[1], max_nums[2] = -1, -1, -1
    max_tot[0] = -1
    find_move_type(0, 0, sr, sc)  # max_nums로 이동하는게 최적임

    for di in max_nums:
        sr, sc = sr + sdr[di], sc + sdc[di]
        if arr[sr][sc]:
            arr[sr][sc] = []
            smell_arr[sr][sc] = time + 2


# 로직 ------------------------------------------------
time = 0
for time in range(1, S + 1):
    # 복제 마법
    copy_arr = [[fd[:] for fd in lst] for lst in arr]  # 깊은복사
    print_info()

    # 한칸 이동
    arr = move_fish()
    print_info()

    # 상어 이동
    move_shark()
    print_info()

    # 2번 전 냄새 사라짐
    # 이건 시간으로 관리했으니 처리 안해줘도 괜찮음

    # 복제 물고기 합치기
    for r in range(N):
        for c in range(N):
            arr[r][c].extend(copy_arr[r][c])
    print_info()
    a = 1

# 정답처리 --------------------------------------------------------------
ans = 0
for r in range(N):
    for c in range(N):
        ans += len(arr[r][c])

print(ans)