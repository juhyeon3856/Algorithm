N, M = map(int, input().split())
# 0빈칸, 1~5 자신말, 6은 상대말
arr = [list(map(int, input().split())) for _ in range(N)]

# 전처리
dr = [-1, 0, 1, 0]  # 상우하좌
dc = [0, 1, 0, -1]
# padding, 상, 좌우, 상우, 상좌우, 상하좌우
dd = [(100), [[0], [1], [2], [3]], [(1, 3), (0, 2)], [(0, 1), (1, 2), (2, 3), (3, 0)],
      [(3, 0, 1), (0, 1, 2), (1, 2, 3), (2, 3, 0)], [(0, 1, 2, 3)]]

debug = 0  # dd, dr, dc 확인! 맵 찍어보기

# for i in range(1, 6):
#     for fd in dd[i]:
#         test_map = [[0] * 5 for _ in range(5)]
#         for d in fd:
#             test_map[2 + dr[d]][2 + dc[d]] = 1
#         debug = 1


# 나의 말이 들어있는 리스트
mys = []
for r in range(N):
    for c in range(M):
        if 1 <= arr[r][c] <= 5:  # 나의 말이면
            mys.append((r, c, arr[r][c]))

my_cnt = len(mys)

# 말이 갈 수 있는곳 표시
board = [[0] * M for _ in range(N)]

# 로직
ans = [10000]  # 최대 64
# debug_lst = [0] * my_cnt
# cnt = [0]


def btk(depth):  # 터질거같으면 푸르닝하자
    if depth == my_cnt:
        # print(*debug_lst)
        # cnt[0] += 1
        _ans = is_ans()  # board에 0 개수 세기
        ans[0] = _ans if ans[0] > _ans else ans[0]
        return
    cr, cc, ct = mys[depth]  # 위치, 타입
    for d in dd[ct]:
        # debug_lst[depth] = (depth, ct, d)
        update_board(cr, cc, d, 1)
        btk(depth + 1)
        update_board(cr, cc, d, -1)


def is_ans():
    result = 0
    for r in range(N):
        for c in range(M):
            if board[r][c] == 0 and arr[r][c] == 0:
                result += 1
    return result


def update_board(fr, fc, fd, delta):
    for d in fd:
        cr, cc = fr + dr[d], fc + dc[d]
        while check(cr, cc) and arr[cr][cc] < 6:
            board[cr][cc] += delta
            cr, cc = cr + dr[d], cc + dc[d]


def check(fr, fc):
    return 0 <= fr < N and 0 <= fc < M


btk(0)
# print(cnt[0])
print(ans[0])
