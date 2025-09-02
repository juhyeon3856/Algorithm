# 입력
N = int(input())
points = [list(map(int, input().split())) for _ in range(N)]
M = int(input())
holes = [list(map(int, input().split())) for _ in range(M)]

# 전처리
depths = []
widths = []
is_holes = []
llen = (N - 2) // 2
max_height = [0] * llen

pw = 0
for i in range(1, N, 2):
    nw, nd = points[i]

    depths.append(nd)

    widths.append(nw - pw)
    pw = nw

    for j in range(M):
        if (nw, nd) == (holes[j][0], holes[j][1]):
            is_holes.append(1)
            break
    else:
        is_holes.append(0)

depths = depths[:-1]
widths = widths[1:]
is_holes = is_holes[:-1]


# [로직1] 구멍에서 출발해서 높이 max 채우기
# def make_max(idx, delta):
#     ci, value = idx, depths[idx]
#     while 0 <= ci < llen:  # 범위 체크
#         if depths[ci] < value:  # 작으면 그만함
#             return
#         max_height[ci] = max(value, max_height[ci])
#         ci += delta

def make_max(si, delta):
    cur_hole, ci = 0, si
    for _ in range(llen):
        if is_holes[ci]:
            cur_hole = depths[ci]
        cur_hole = min(cur_hole, depths[ci])
        max_height[ci] = max(cur_hole, max_height[ci])
        ci += delta


make_max(0, 1)
make_max(llen - 1, -1)
# cur_hole = 0
# for i in range(llen):
#     if is_holes[i]:
#         cur_hole = depths[i]
#     cur_hole = min(cur_hole, depths[i])
#     max_height[i] = max(cur_hole, max_height[i])
#
# cur_hole = 0
# for i in range(llen - 1, -1, -1):
#     if is_holes[i]:
#         cur_hole = depths[i]
#     else:
#         cur_hole = min(cur_hole, depths[i])
#     max_height[i] = max(cur_hole, max_height[i])

# for i in range(llen):
#     if is_holes[i]:
#         make_max(i, 1)
#         make_max(i, -1)

# [로직2] max_height가 물 빠지는 높이 -> 남은 물 높이 및 너비로 ans계산
ans = 0
for i in range(llen):
    ans += max(0, (depths[i] - max_height[i]) * widths[i])

print(ans)
