N = 4

dr = [-1, -1, 0, 1, 1, 1, 0, -1]
dc = [0, -1, -1, -1, 0, 1, 1, 1]
ds = ['↑', '↖', '←', '↙', '↓', '↘', '→', '↗']


def check(fr, fc):
    return 0 <= fr < N and 0 <= fc < N


def move(carr, csr, csc, fr, fc, fd):
    for _ in range(8):  # 무조건 움직일수 있을듯
        nr, nc = fr + dr[fd], fc + dc[fd]

        if not check(nr, nc) or (nr, nc) == (csr, csc):  # 나가거나 상어가 있는 칸이면
            fd = (fd + 1) % 8
            continue

        # 다른 물고기 있거나 빈칸이면
        temp = carr[fr][fc][0]
        carr[fr][fc] = carr[nr][nc]  # 두 물고기 위치 바꾸기
        carr[nr][nc] = temp, fd
        return


# 입력
arr = [[0] * N for _ in range(N)]
for r in range(N):
    lst = list(map(int, input().split()))
    for c in range(N):
        arr[r][c] = (lst[c * 2], lst[c * 2 + 1] - 1)


def move_fish(fi, cur_arr, sr, sc):
    for r in range(N):
        for c in range(N):
            if cur_arr[r][c][0] == fi:
                move(cur_arr, sr, sc, r, c, cur_arr[r][c][1])
                return


def btk(depth, ssum, farr, sr, sc, sd):  # 깊이, 현재 합, map모양, 상어위치
    cur_arr = [lst1[:] for lst1 in farr]  # 깊은복사

    # 물고기 이동
    for ii in range(1, 17):
        move_fish(ii, cur_arr, sr, sc)
        # print_arr(cur_arr)

    # 상어 이동
    for s in (1, 2, 3):
        nsr, nsc = sr + dr[sd] * s, sc + dc[sd] * s

        if not check(nsr, nsc):
            sum_max[0] = ssum if ssum > sum_max[0] else sum_max[0]
            continue

        if cur_arr[nsr][nsc] == (-1, 100):
            sum_max[0] = ssum if ssum > sum_max[0] else sum_max[0]
            continue

        target_fish = cur_arr[nsr][nsc]
        cur_arr[nsr][nsc] = (-1, 100)
        btk(depth + 1, ssum + target_fish[0], cur_arr, nsr, nsc, target_fish[1])
        cur_arr[nsr][nsc] = target_fish

def print_arr(ffarr):
    print("========================")
    for r in range(N):
        for c in range(N):
            if ffarr[r][c][0] > 0:
                print(f"{ffarr[r][c][0]}{ds[ffarr[r][c][1]]}", end="\t")
            else:
                print(" ", end='\t')
        print()


sum_max = [0]
start_id, start_d = arr[0][0][0], arr[0][0][1]
arr[0][0] = (-1, 100)
btk(0, start_id, arr, 0, 0, start_d)

print(sum_max[0])
