# 한번 돌려서 풀 수 있는지 확인
# 가로, 세로 4개씩 관리하면서 가로, 세로를 좌, 우 쉬프트 후 동일한지 확인함

N = 2

lst = [0] + list(map(int, input().split()))

idx1 = [24, 22, 1, 3, 5, 7, 9, 11, 24, 22]
idx2 = [23, 21, 2, 4, 6, 8, 10, 12, 23, 21]
idx3 = [21, 22, 13, 14, 5, 6, 17, 18, 21, 22]
idx4 = [23, 24, 15, 16, 7, 8, 19, 20, 23, 24]
idx5 = [3, 4, 17, 19, 10, 9, 16, 14, 3, 4]
idx6 = [1, 2, 18, 20, 12, 11, 15, 13, 1, 2]

ans = 0


# 함수들

# 4개의 색이 다 같은지 확인
def check(n1, n2, n3, n4):
    return lst[n1] == lst[n2] and lst[n2] == lst[n3] and lst[n3] == lst[n4]


# 줄 단위로 4칸씩 같은지 보는 함수
def check_line(line1, line2):
    for i in range(0, N * 4, N):
        if not check(line1[i], line1[i + 1], line2[i], line2[i + 1]):
            return False
    return True


# 세로로 돌리면
if check(17, 18, 19, 20) and check(13, 14, 15, 16):
    if check_line(idx1[:4 * N], idx2[N:]) or check_line(idx2[:4 * N], idx1[N:]):
        ans = 1

# 가로로 돌리면
if check(1, 2, 3, 4) and check(9, 10, 11, 12):
    if check_line(idx3[:4 * N], idx4[N:]) or check_line(idx4[:4 * N], idx3[N:]):
        ans = 1

# 가로로 돌리면
if check(5, 6, 7, 8) and check(21, 22, 23, 24):
    if check_line(idx5[:4 * N], idx6[N:]) or check_line(idx6[:4 * N], idx5[N:]):
        ans = 1

print(ans)