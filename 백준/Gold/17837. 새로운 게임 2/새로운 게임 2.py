

# 7시 12분 시작
# 17분 코드 작성 시작
# 31분 디버깅 시작
# 56분 제출


N, K = map(int, input().split())
board = [[2] * (N + 2)] + [[2] + list(map(int, input().split())) + [2] for _ in range(N)] + [[2] * (N + 2)]
stone_lst = [0] + [list(map(int, input().split())) for _ in range(K)]

dr = [100, 0, 0, -1, 1]
dc = [100, 1, -1, 0, 0]  # 우좌상하
dt = [100, 2, 1, 4, 3]
stone_arr = [[[] for _ in range(N + 2)] for _ in range(N + 2)]
for i in range(1, K + 1):
    gr, gc, gd = stone_lst[i]
    stone_arr[gr][gc].append([i, gd])

    # 로직 시작


def find_num(num):
    for r in range(N + 2):
        for c in range(N + 2):
            for vi in range(len(stone_arr[r][c])):
                if stone_arr[r][c][vi][0] == num:
                    return r, c, vi, stone_arr[r][c][vi][1]


def sol():
    for time in range(1, 1001):
        for i in range(1, K + 1):
            gr, gc, hi, gd = find_num(i)
            nr, nc = gr + dr[gd], gc + dc[gd]
            if board[nr][nc] == 2:
                stone_arr[gr][gc][hi][1] = dt[gd]  # 방향 전환
                gd = stone_arr[gr][gc][hi][1]
                nr, nc = gr + dr[gd], gc + dc[gd]
            # 이제 진짜 이동
            # for vi in range(len(stone_arr[gr][gc])):
            #     if stone_arr[gr][gc][vi] == i:
            #         hi = vi
            #         break
            if board[nr][nc] == 0:
                move_lst = stone_arr[gr][gc][hi:]
                stone_arr[gr][gc] = stone_arr[gr][gc][:hi]
                stone_arr[nr][nc].extend(move_lst)
                if len(stone_arr[nr][nc]) >= 4:
                    return time

            elif board[nr][nc] == 1:
                move_lst = stone_arr[gr][gc][hi:]
                stone_arr[gr][gc] = stone_arr[gr][gc][:hi]
                stone_arr[nr][nc].extend(move_lst[::-1])
                if len(stone_arr[nr][nc]) >= 4:
                    return time
    return -1


print(sol())
