# 시간복잡도
# 한번 이동시킬때 -> n*n -> 20*20
# 총 4가지 방향(상하좌우) (최대 5회) -> 4*4*4*4*4 = 1024
# 그냥 5회 다 하고 한번 확인하면 될듯 -> n*n
# 20 20 1024 20 20

# 입력
N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]

# 전처리
ans = [0]

dr = [0, 0, -1, 1]
dc = [-1, 1, 0, 0]

# 시작인덱스, 끝 인덱스, 델타값
ds = [0, N - 1, 0, N - 1]  # 상하좌우
de = [N, -1, N, -1]
dd = [1, -1, 1, -1]


# 함수들
def move(depth, cur_arr, pd):
    # 98096937(강사님 푸르닝 풀이 참조)
    # [0] 가지치기: 남은 동안 제일 큰 값이 2배씩 커져도 정답을 못이기면..
    if (max(map(max, cur_arr)) * (2 ** (5 - depth))) <= ans[0]:
        return

    if depth == 5:  # 5번 이동시켰으면
        max_value = find_max_value(cur_arr)
        if ans[0] < max_value:
            ans[0] = max_value
        return

    # 위로 이동
    # if pd[-1] != 1:
    new_arr = []
    for lst in zip(*cur_arr):
        new_arr.append(move_line(list(lst), 0, N, 1))  # 리스트, 시작, 끝인덱스, delta
    move(depth + 1, [list(lst) for lst in zip(*new_arr)], pd + [1])

    # 아래로 이동
    # if pd[-1] != 2:
    new_arr = []
    for lst in zip(*cur_arr):
        new_arr.append(move_line(list(lst), N - 1, -1, -1))  # 리스트, 시작, 끝인덱스, delta
    move(depth + 1, [list(lst) for lst in zip(*new_arr)], pd + [2])

    # 좌로 이동
    # if pd[-1] != 3:
    new_arr = []
    for lst in cur_arr:
        new_arr.append(move_line(lst, 0, N, 1))  # 리스트, 시작, 끝인덱스, delta
    move(depth + 1, new_arr, pd + [3])

    # 우로 이동
    # if pd[-1] != 4:
    new_arr = []
    for lst in cur_arr:
        new_arr.append(move_line(lst, N - 1, -1, -1))  # 리스트, 시작, 끝인덱스, delta
    move(depth + 1, new_arr, pd + [4])


def move_line(flst, si, ei, delta):
    result = [0] * N
    ci = si  # 작성할 인덱스

    for i in range(si, ei, delta):
        if flst[i] == 0:  # 없으면
            continue
        if result[ci]:
            if result[ci] == flst[i]:  # 두 값이 같으면
                result[ci] += flst[i]
                ci += delta
            else:  # 다르면 다음 칸에
                ci += delta
                result[ci] += flst[i]
        else:  # 0이면
            result[ci] += flst[i]
    return result


# move_line테스트
# N = 8
# debug = move_line([0, 1, 2, 1, 1, 0, 1, 1], 0, N, 1)
# debug = move_line([0, 1, 2, 1, 1, 0, 1, 1], N-1, -1, -1)
# debug = 0


# 현재 farr에서 최댓값 찾는 함수
def find_max_value(farr):
    result = 0
    for r in range(N):
        for c in range(N):
            result = farr[r][c] if farr[r][c] > result else result
    return result


# 로직
move(0, arr, [0])

# 정답출력
print(ans[0])
