def move(sr, sc, w, h):
    read_lst = read(sr, sc, w, h)  # sr, sc에서 시작하고 가로가 w, 세로가 H인 layer 읽어오기
    r = R % (w + w + h + h - 4)
    write(sr, sc, w, h, read_lst[r:] + read_lst[:r])


def read(sr, sc, w, h):
    result = arr[sr][sc: sc + w]
    result += read_ver(sr + 1, sc + w - 1, h - 2, 1)  # 시작 r, 시작 c, 개수, 방향
    result += arr[sr + h - 1][sc + w - 1: sc - 1: -1]
    result += read_ver(sr + h - 2, sc, h - 2, -1)
    return result


def read_ver(sr, sc, read_cnt, delta):
    result = []
    for _ in range(read_cnt):
        result.append(arr[sr][sc])
        sr += delta
    return result


def write(sr, sc, w, h, lst):
    arr[sr][sc: sc + w] = lst[:w]
    write_ver(sr + 1, sc + w - 1, 1, lst[w: w + h - 2])
    arr[sr + h - 1][sc + w - 1: sc - 1: -1] = lst[w + h - 2:w + h + w - 2]
    write_ver(sr + h - 2, sc, -1, lst[w + h + w - 2:])


def write_ver(sr, sc, delta, lst):
    for num in lst:
        arr[sr][sc] = num
        sr += delta


def print_arr():
    for lst in arr[1:-1]:
        print(*lst[1:-1])


N, M, R = map(int, input().split())
arr = [[0] * (M + 1)] + [[0] + list(map(int, input().split())) + [0] for _ in range(N)] + [[0] * (M + 1)]

layer = N // 2 if N < M else M // 2

# 입력 및 전처리 완료! 로직 시작
for i in range(layer):
    move(i + 1, i + 1, M - 2 * i, N - 2 * i)

print_arr()