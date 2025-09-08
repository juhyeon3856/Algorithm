# 입력
T = int(input())
N, M = 6, 4

# 전처리
blue_arr = [[0] * M for _ in range(N)] + [[1] * M]
green_arr = [[0] * M for _ in range(N)] + [[1] * M]

ans = 0


# 2*1, 1*2도 1*1로 잘라서 보내기, return : blue 내릴곳, green 내릴곳
def ttype(t, r, c):
    if t == 1:
        return [(0, r)], [(0, c)]
    elif t == 2:
        return [(0, r), (-1, r)], [(0, c), (0, c + 1)]
    elif t == 3:
        return [(0, r), (0, r + 1)], [(0, c), (-1, c)]


# tc행에 블럭 떨어뜨리기
def down(arr, block):
    for r in range(N + 1):
        for _, c in block:
            if arr[r][c] == 1:
                for dr, tc in block:
                    arr[r + dr - 1][tc] = 1
                return
    print("NOOOOOOOOOOOOOO")


# 그 행 지우기
def delete_row(arr, dr):
    for r in range(dr, 0, -1):
        arr[r] = arr[r - 1]
    arr[0] = [0] * M  # 가장 위에 빈거 하나 넣어주기


# 한 행 전부 블럭 있으면 제거 and 점수
def is_score(arr):
    result = 0  # 획득한 점수
    for r in range(2, N):
        if sum(arr[r]) == M:
            result += 1  # 점수 +1
            delete_row(arr, r)  # 4개 다 있는거 제거
    return result  # 획득한 점수


# 넘치는 것 처리(연한 초록, 파랑)
def remove_over(arr):
    for _ in range(2):
        if sum(arr[1]) > 0:  # 하나라도 있으면
            delete_row(arr, N - 1)  # 가장 아래 행 제거


def cnt_block(arr):
    result = 0  # 블럭 개수
    for r in range(N):
        for c in range(M):
            if arr[r][c] == 1:
                result += 1
    return result  # 블럭 개수


# 로직
for _ in range(T):
    it, ir, ic = map(int, input().split())
    blue, green = ttype(it, ir, ic)

    # 파란색, 초록색에 내리기
    down(blue_arr, blue)  # blue_arr에 dc번째 컬럼에 내리기
    down(green_arr, green)  # green_arr에 dc번째 컬럼에 내리기

    # 점수 얻기
    ans += is_score(blue_arr)
    ans += is_score(green_arr)

    # 넘치는 것 처리
    remove_over(blue_arr)
    remove_over(green_arr)

# 정답 처리
print(ans)
print(cnt_block(blue_arr) + cnt_block(green_arr))