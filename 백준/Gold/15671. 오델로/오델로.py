N = 6
board = [['.'] * N for _ in range(N)]
board[2][2] = 'W'
board[3][3] = 'W'
board[2][3] = 'B'
board[3][2] = 'B'

dr = [-1, -1, 0, 1, 1, 1, 0, -1]
dc = [0, 1, 1, 1, 0, -1, -1, -1]


# 입력 완료! 로직 시작
def isChange(fr, fc):
    result = []
    for d in range(8):  # 8방향
        nr, nc = fr + dr[d], fc + dc[d]
        # .이 아니고, 서로 다르면 -> 그럼 끝나는 경우 nr, nc에는 .이거나 같은거
        while 0 <= nr < N and 0 <= nc < N and board[nr][nc] != '.' and board[nr][nc] != board[fr][fc]:
            nr += dr[d]
            nc += dc[d]
        if not(0 <= nr < N and 0 <= nc < N):
            continue
        if board[nr][nc] == '.':
            continue
        else:  # fr, fc와 nr, nc값 같음
            result.append(d)
    return result


def change(fr, fc, fd):
    for d in fd:
        nr, nc = fr + dr[d], fc + dc[d]
        # 다른 색이면 바꿈
        while 0 <= nr < N and 0 <= nc < N and board[nr][nc] != board[fr][fc]:
            board[nr][nc] = board[fr][fc]
            nr += dr[d]
            nc += dc[d]


# 흑 선
T = int(input())
for i in range(T):
    r, c = map(lambda x:int(x) - 1, input().split())
    turn = 'B' if i % 2 == 0 else 'W'
    board[r][c] = turn
    dd = isChange(r, c)
    if dd:  # 뒤집어야하면
        change(r, c, dd)  # 뒤집기

# 게임 끝! 돌의 수 세기
cnt_b = 0
cnt_w = 0
for r in range(N):
    for c in range(N):
        if board[r][c] == 'W':
            cnt_w += 1
        elif board[r][c] == 'B':
            cnt_b += 1

for bb in board:
    print(*bb, sep="")
print("Black" if cnt_b > cnt_w else "White")