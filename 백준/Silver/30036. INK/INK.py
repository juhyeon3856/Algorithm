I, N, K = map(int, input().split())
ink = input()

board = [list(input()) for _ in range(N)]
# 사각형은 @, 빈칸은 . , 장애물은 #

commands = list(input())
ink_cnt = [0]
jump_cnt = [0]


# U D L R로 4가지이고 각각 상, 하, 좌, 우 방향으로 1칸 이동함
# 사각형이 스테이지 밖으로 벗어나거나 장애물과 겹치는 경우 해당 커맨드는 무시

# j : 잉크 충전 : 잉크 양 +1
# 게임 처음 시작 시 잉크 0

# J : 점프 하면서 가지고 있는 잉크 전부 흩뿌리기
# 색상 ci, 양 mi잉크가 (r, c)에 뿌려지면 abs(r-a) + abs(r-b) <= mi인 장애문 칸을 ci로 칠하기
# -> 즉, 뿌린 위치로 부터 맨해튼 거리에 있는 장애물 ci로 칠하기
# 색상은 무조건 덮어씌우기
# 점프 직 후 잉크양 0

# 잉크 색상 정하는 법
# 점프 횟수 % 잉크문자열 길이

# 출력 : 커맨드 실행 후 스테이지 모습

# 입력 완료 로직 시작

def move(r, c, dir):
    if dir == 'U':
        nr, nc = r - 1, c
    elif dir == 'D':
        nr, nc = r + 1, c
    elif dir == 'L':
        nr, nc = r, c - 1
    elif dir == 'R':
        nr, nc = r, c + 1
    else:
        nr, nc = -1, -1
        print('NOOOOOOOOOOOOOO')
    if check(nr, nc):  # 범위 안이면
        if board[nr][nc] == '.':  # 장애물이랑 안 겹치면
            return nr, nc
    return r, c


def check(r, c):
    return 0 <= r < N and 0 <= c < N


def j():
    ink_cnt[0] += 1


def J(r, c):
    color = ink[jump_cnt[0] % I]
    for mi in range(1, ink_cnt[0] + 1):  # 맨해튼 거리 mi인 것들 다
        for dr in range(-mi, mi + 1):
            for dc in (mi - abs(dr), abs(dr) - mi):
                nr, nc = r + dr, c + dc
                if not check(nr, nc):
                    continue
                if board[nr][nc] == '.':
                    continue
                board[nr][nc] = color
    jump_cnt[0] += 1
    ink_cnt[0] = 0


def print_board():
    for bb in board:
        print(*bb, sep="")


cr, cc = -1, -1
for r in range(N):
    for c in range(N):
        if board[r][c] == '@':
            cr, cc = r, c
            board[r][c] = '.'

# print_board()

for command in commands:
    debug = 0
    if command == 'j':
        j()
    elif command == 'J':
        J(cr, cc)
    else:
        cr, cc = move(cr, cc, command)

board[cr][cc] = '@'
print_board()

# J test
# board = [['#'] * 20 for _ in range(20)]
# ink_cnt[0] = 15
# N = 20
# J(10, 10)
#
# print("========================")
# print_board()
# print("========================")