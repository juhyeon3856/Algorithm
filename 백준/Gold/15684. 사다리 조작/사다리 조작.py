# 입력
n, k, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(k)]

# 전처리
N, M = m, n - 1
board = [[0] * (M + 2) for _ in range(N + 1)]  # 사다리 유무, 열 양쪽 패딩
for i, j in arr:
    board[i][j] = 1

ans = -1


# 테스트
# for i in range(N * M):
#     r, c = (i // M) + 1, (i % M) + 1
#     board[r][c] = 2
#
# debug = 0  # board확인해보기


# 함수들
def combi(depth, start):
    if depth == R:
        return is_ans()  # 사다리 타보고 정답이면

    for i in range(start, N * M):
        r, c = (i // M) + 1, (i % M) + 1
        if board[r][c]:
            continue
        if board[r][c - 1]:
            continue
        if board[r][c + 1]:
            continue

        board[r][c] = 1
        if combi(depth + 1, i + 1):
            return 1
        board[r][c] = 0


def is_ans():
    for sc in range(1, M + 2):
        cc = sc
        for cr in range(1, N + 1):
            if board[cr][cc]:
                cc += 1
            elif board[cr][cc - 1]:
                cc -= 1
        if sc != cc:
            return 0
    return 1


# 로직
nums = [(100, 100), (100, 100), (100, 100)]
for R in range(4):
    if combi(0, 0):  # 남은것 중 i개 고르기
        ans = R
        break

# 정답출력
print(ans)
