# [1] 이동 방향 만들기
# g세대는 1<<g까지 인덱스 이동만 하면 된다.
def make_dir():
    new_lst = []
    for cur_dir in dir_lst[::-1]:
        new_lst.append((cur_dir + 1) % 4)
    return new_lst


dir_lst = [0]
for _ in range(10):
    dir_lst += make_dir()

# for i in range(0, len(dir_lst), 4):
#     print(dir_lst[i + 0], dir_lst[i + 1], dir_lst[i + 2], dir_lst[i + 3])

# [2] (cr, cc)에서 (nr, nc)로 이동했을 때 어떤 사각형에 영향을 주는지 알아보자

# point_to_line = {(0, 1): [(-1, 0, 2), (0, 0, 0)],
#                  (0, -1): [(-1, -1, 2), (0, -1, 0)],
#                  (1, 0): [(0, -1, 1), (0, 0, 3)],
#                  (-1, 0): [(-1, 0, 3), (-1, -1, 1)]}
#
# visited = [[[0] * 4 for _ in range(100)] for _ in range(100)]
#
#
# def visited_check(cr, cc, nr, nc):
#     key_point = (nr - cr, nc - cc)
#     for vr, vc, vd in point_to_line.get(key_point):
#         if 0 <= cr + vr < 100 and 0 <= cc + vc < 100:
#             visited[cr + vr][cc + vc][vd] += 1


visited = [[0] * 101 for _ in range(101)]

dr = [0, -1, 0, 1]
dc = [1, 0, -1, 0]


# for ddd in range(4):
#     visited = [[[0] * 4 for _ in range(4)] for _ in range(4)]
#     visited_check(2, 2, 2 + dr[ddd], 2 + dc[ddd])


# [3] 드래곤을 이동시키자
def move(fr, fc, fd, fg):
    cr, cc = fr, fc
    visited[fr][fc] += 1
    for di in range(1 << fg):
        cd = (dir_lst[di] + fd) % 4
        nr, nc = cr + dr[cd], cc + dc[cd]
        visited[nr][nc] += 1  # 범위 넘어가지 않음
        cr, cc = nr, nc
        # visited_check(cr, cc, nr, nc)


# 입력


DD = int(input())
for _ in range(DD):
    sc, sr, sd, sg = map(int, input().split())
    move(sr, sc, sd, sg)  # 드래곤 이동

# 정답체크
ans = 0
for r in range(100):
    for c in range(100):
        if visited[r][c] == 0:
            continue
        if visited[r + 1][c] == 0:
            continue
        if visited[r][c + 1] == 0:
            continue
        if visited[r + 1][c + 1] == 0:
            continue
        ans += 1

print(ans)

# for i in range(10):
#     print(*visited[i][:10])
