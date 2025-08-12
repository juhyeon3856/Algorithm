# 입력
N, M, R = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
commands = list(map(int, input().split()))


# 함수 기능 구현
def move1():
    '''
    상하 반전시키는 연산
    :return:
    '''
    for c in range(M):
        for r in range(N // 2):
            arr[r][c], arr[N - r - 1][c] = arr[N - r - 1][c], arr[r][c]


def move2():
    '''
    좌우 반전시키는 연산
    :return:
    '''
    for r in range(N):
        for c in range(M // 2):
            arr[r][c], arr[r][M - c - 1] = arr[r][M - c - 1], arr[r][c]


def move3():
    '''
    오른쪽으로 90도 회전시키는 연산
    :return:
    '''
    global arr, N, M
    temp_arr = [arr[r][:] for r in range(N)]
    N, M = M, N
    arr = [[0] * M for r in range(N)]
    for r in range(N):
        for c in range(M):
            arr[r][c] = temp_arr[M - c - 1][r]


def move4():
    '''
    왼쪽으로 90도 회전시키는 연산
    :return:
    '''
    global arr, N, M
    temp_arr = [arr[r][:] for r in range(N)]
    N, M = M, N
    arr = [[0] * M for r in range(N)]
    for r in range(N):
        for c in range(M):
            arr[r][c] = temp_arr[c][N - r - 1]


# N/2×M/2인 4개의 부분 배열로 나눠야 한다
def move5():
    '''
    1->2 / 2->3 / 3->4 / 4->1
    :return:
    '''
    n, m = N // 2, M // 2
    # 1번 덜어두고
    temp_arr = [arr[r][:m] for r in range(n)]

    # 4 -> 1
    for r in range(n):
        arr[r][:m] = arr[n + r][:m]

    # 3 -> 4
    for r in range(n):
        arr[n + r][:m] = arr[n + r][m:]

    # 2 -> 3
    for r in range(n):
        arr[n + r][m:] = arr[r][m:]

    # 1 -> 2
    for r in range(n):
        arr[r][m:] = temp_arr[r][:]


def move6():
    '''
    1->4 / 4->3 / 3->2 / 2->1
    :return:
    '''
    n, m = N // 2, M // 2
    # 1번 덜어두고
    temp_arr = [arr[r][:m] for r in range(n)]

    # 2 -> 1
    for r in range(n):
        arr[r][:m] = arr[r][m:]

    # 3 -> 2
    for r in range(n):
        arr[r][m:] = arr[n + r][m:]

    # 4 -> 3
    for r in range(n):
        arr[n + r][m:] = arr[n + r][:m]

    # 1 -> 4
    for r in range(n):
        arr[n + r][:m] = temp_arr[r][:]


def print_arr():
    # print("=======================")
    for lst in arr:
        print(*lst)


# test
# N, M = 4, 6
# arr = [[i + M * j + 10 for i in range(M)] for j in range(N)]
# print_arr()
# move6()
# print_arr()


def do_command():
    for command in commands:
        if command == 1:
            move1()
        elif command == 2:
            move2()
        elif command == 3:
            move3()
        elif command == 4:
            move4()
        elif command == 5:
            move5()
        elif command == 6:
            move6()


do_command()
print_arr()
