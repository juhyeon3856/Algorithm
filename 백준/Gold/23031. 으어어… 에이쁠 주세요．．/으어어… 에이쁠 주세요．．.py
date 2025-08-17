# 1, 1 에서 출발
# 처음에 아래 방향 봄
#
# F: 앞으로 전진, R: 오른쪽 회전, L: 왼쪽 회전
# 벽 만나면 이동
# 하지않고 패스
#
# 스위치 만나면 무조건 형광등 켬
# 스위치는 8 방으로 총 9 칸이 켜짐
#
# 아리 이동 후 좀비 이동
#
# 좀비 벽 만나면 방향 180 도 전환
#
# 불이 꺼진 칸에서 좀비 만나면 바로 기절
# 켜져있으면 괜춘 스위치 먼저 켬
#
# Z학생좀비 0　 S스위치


# 아리 이동 (좀비 만나면 True)
def amove(ttype):
    global ar, ac, dir
    if ttype == 'F':  # 한칸 전진
        nr, nc = ar + dr[dir], ac + dc[dir]
        if not check(nr, nc):  # 범위 밖이면 이동 안함
            return False

        if board[nr][nc] == 'S':  # 스위치면
            light_on(nr, nc)

        if zboard[nr][nc]:  # 좀비 만났는데
            if not light[nr][nc]:  # 불 꺼져있으면
                return True

        ar, ac = nr, nc

    elif ttype == 'L':  # 왼쪽 회전
        dir = (dir + 3) % 4
    elif ttype == 'R':  # 오른쪽 회전
        dir = (dir + 1) % 4


# 8방 불켜기
lr = [0, 0, 0, -1, -1, -1, 1, 1, 1]
lc = [0, -1, 1, 0, -1, 1, 0, -1, 1]


def light_on(r, c):
    for d in range(9):
        nr, nc = r + lr[d], c + lc[d]
        if not check(nr, nc):  # 범위 밖이면
            continue
        light[nr][nc] += 1


# 좀비 이동 (아리 만나면 true)
def zmove():
    for i in range(M):
        cr, cc, cd = zlst[i]
        nr, nc = cr + dr[cd], cc + dc[cd]
        if check(nr, nc):  # 범위 안이면
            if (nr, nc) == (ar, ac):  # 아리 만났는데
                if not light[nr][nc]:  # 불 꺼져있으면
                    return True
            zboard[cr][cc] -= 1
            zboard[nr][nc] += 1
            zlst[i][0], zlst[i][1] = nr, nc
        else:
            zlst[i][2] = (cd + 2) % 4  # 방향 전환


# 범위 확인
def check(r, c):
    return 0 <= r < N and 0 <= c < N


# 입력
N = int(input())
commands = input()
board = [list(input()) for _ in range(N)]

# 전처리
zlst = []  # 좀비(r, c, dir)
zboard = [[0] * N for _ in range(N)]

for r in range(N):
    for c in range(N):
        if board[r][c] == 'Z':
            zlst.append([r, c, 2])  # 처음에는 다 아래방향
            zboard[r][c] += 1
            board[r][c] = 'O'
M = len(zlst)  # 좀비 수

ar, ac, dir = 0, 0, 2  # 아리 현재 위치 및 방향(아래)
dr, dc = [-1, 0, 1, 0], [0, 1, 0, -1]  # 상우하좌

light = [[0] * N for i in range(N)]

ans = "Phew..."

# 로직
for command in commands:
    if amove(command):  # 사람이동
        ans = "Aaaaaah!"  # 만났음
        break

    if zmove():  # 좀비이동
        ans = "Aaaaaah!"  # 만났음
        break

    debug = 0

print(ans)