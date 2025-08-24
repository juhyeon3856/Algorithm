# 40 * 40 * 100 * 4 = 640,000 -> 그냥 완탄 가능


# 스티커 붙일 수 있는지
def check():
    for sr in range(N):
        for sc in range(M):
            if is_stick(sr, sc):
                do_stick(sr, sc)
                return True
    return False


def is_stick(sr, sc):
    for r in range(R):
        for c in range(C):
            if not oob(sr + r, sc + c):  # 범위 벗어나면
                return False

            if not stick[r][c]:  # 스티커 없으면
                continue

            if board[sr + r][sc + c]:  # 이미 스티커 붙어있으면
                return False

    return True


def oob(fr, fc):
    return 0 <= fr < N and 0 <= fc < M


def do_stick(sr, sc):
    for r in range(R):
        for c in range(C):
            board[sr + r][sc + c] |= stick[r][c]


def do_turn():
    new_stick = [[0] * R for _ in range(C)]

    for r in range(C):
        for c in range(R):
            new_stick[r][c] = stick[R - 1 - c][r]

    return new_stick


# test
# R, C = 3, 4
# stick = [[i * C + j for i in range(C)] for j in range(R)]
# print(*stick, sep='\n')
# print(*do_turn(), sep='\n')


N, M, K = map(int, input().split())

board = [[0] * M for _ in range(N)]

for _ in range(K):  # 스티커 붙이기
    R, C = map(int, input().split())
    stick = [list(map(int, input().split())) for _ in range(R)]

    for _ in range(4):
        if check():
            break  # 붙였으니까 그만

        stick = do_turn()  # 시계방향 90도 회전
        R, C = C, R

# 붙여진 스티커 count
ans = 0
for r in range(N):
    for c in range(M):
        if board[r][c]:
            ans += 1

print(ans)