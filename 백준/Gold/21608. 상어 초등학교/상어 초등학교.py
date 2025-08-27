# 1시 40분

'''
로직

1. 자리배치(인접한곳에)
    - 좋아하는 학생 많은 곳으로
    - 빈칸이 많은 곳으로
    - 행 번호 작은 곳으로
    - 열 번호 작은곳으로


2. 만족도 조사(set 길이를 잘 써보자)
    - r, c 순회하면서 조사
    - 복잡도 N * N
'''

# 입력
N = int(input())

# 전처리
board = [[0] * N for _ in range(N)]
input_dic = {}
students = {}

dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]


# 다시다시 어렵게 가지말자 그냥 완탐하자...*******************

# 학생 배치
def go_stu(num):
    # 선호학생 수, 빈칸 수 세기
    like_cnt = [[0] * N for _ in range(N)]
    for r in range(N):
        for c in range(N):
            like_cnt[r][c] = cnt_like(num, r, c)

    # 최댓값 찾기, 튜플 최대 찾으면 됌
    mx = (-1, -1)
    result = (-1, -1)
    for r in range(N):
        for c in range(N):
            if board[r][c]:  # 주인있으면
                continue

            if mx < like_cnt[r][c]:  # 최댓값이면
                mx = like_cnt[r][c]
                result = (r, c)
    return result


def cnt_like(num, r, c):
    lcnt, bcnt = 0, 0
    check_set = input_dic.get(num)
    for d in range(4):
        nr, nc = r + dr[d], c + dc[d]
        if not check(nr, nc):
            continue
        if board[nr][nc] == 0:  # 빈칸이면
            bcnt += 1
        elif board[nr][nc] in check_set:
            lcnt += 1
    return lcnt, bcnt


def check(r, c):
    return 0 <= r < N and 0 <= c < N


def do_score():
    result = 0
    for r in range(N):
        for c in range(N):
            result += check_score(r, c)
    return result


def check_score(r, c):
    num = board[r][c]
    want = input_dic.get(num)
    real = set()
    for d in range(4):
        nr, nc = r + dr[d], c + dc[d]

        if check(nr, nc):
            real.add(board[nr][nc])
    result = len(want & real)
    if result == 0:
        return 0
    elif result == 1:
        return 1
    elif result == 2:
        return 10
    elif result == 3:
        return 100
    elif result == 4:
        return 1000



for _ in range(N * N):
    cn, like1, like2, like3, like4 = map(int, input().split())
    input_dic[cn] = {like1, like2, like3, like4}  # 만족도 조사용

    # 학생 배치
    gr, gc = go_stu(cn)
    board[gr][gc] = cn

# 만족도 조사
print(do_score())