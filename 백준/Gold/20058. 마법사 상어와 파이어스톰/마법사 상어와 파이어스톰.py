from collections import deque

# 입력
N, Q = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(1 << N)]

llst = list(map(int, input().split()))

# 전처리
melt = [[0] * (1 << N) for _ in range(1 << N)]

dr = [0, 0, 1, -1]
dc = [-1, 1, 0, 0]


# fl 만큼 잘라서 회전시키는 함수
def rots(fl):
    for r in range(0, 1 << N, 1 << fl):
        for c in range(0, 1 << N, 1 << fl):
            rot(r, c, fl)


def rot(fr, fc, fl):
    temp_arr = [[0] * (1 << fl) for _ in range(1 << fl)]
    for rr in range(1 << fl):
        for rc in range(1 << fl):
            temp_arr[rr][rc] = arr[fr + (1 << fl) - 1 - rc][fc + rr]

    # 회전값 반영
    for r in range(1 << fl):
        for c in range(1 << fl):
            arr[fr + r][fc + c] = temp_arr[r][c]


# 녹아야하는 얼음 세는 함수
# 녹아야함 -> 1, 안녹아야함 -> 0
def is_melt():
    for r in range(1 << N):
        for c in range(1 << N):
            cnt = 0  # 4방 얼음 개수
            for d in range(4):
                nr, nc = r + dr[d], c + dc[d]
                if not check(nr, nc):  # 범위 밖이면
                    continue
                if not arr[nr][nc]:  # 얼음 없으면
                    continue
                cnt += 1  # 주변 얼음 개수 +=1
            if cnt >= 3:  # 안녹아야함
                melt[r][c] = 0
            else:  # 녹아야함
                melt[r][c] = 1


# 얼음 녹이는 함수
def melt_ice():
    for r in range(1 << N):
        for c in range(1 << N):
            if arr[r][c] and melt[r][c]:  # 얼음이 있고, 녹여야하면
                # if melt[r][c]:  # 녹여햐하면
                arr[r][c] -= 1  # 녹이기


def check(fr, fc):
    return 0 <= fr < (1 << N) and 0 <= fc < (1 << N)


# bfs돌려서 한 그룹 개수 리턴해주기
def bfs(fr, fc, fg):
    result = 1

    queue = deque([(fr, fc)])
    visited[fr][fc] = fg

    while queue:
        cr, cc = queue.popleft()
        for d in range(4):
            nr, nc = cr + dr[d], cc + dc[d]

            if not check(nr, nc):
                continue

            if visited[nr][nc]:
                continue

            if arr[nr][nc] == 0:  # 얼음 없으면
                continue

            queue.append((nr, nc))
            visited[nr][nc] = fg
            result += 1

    return result


# 디버깅용
# def print_arr(farr):
#     print("=====================")
#     for lst in farr:
#         print(*lst, sep="\t")


# print_arr(arr)
# print()
# 로직
for cl in llst:
    rots(cl)
    is_melt()  # 얼음 3칸 이상인거 녹이기
    melt_ice()  # 녹이기
    # print_arr(arr)
    # print_arr(melt)
    # print()

# 정답처리
sum_ice = 0
for r in range(1 << N):
    for c in range(1 << N):
        sum_ice += arr[r][c]

cnt_ice = [0]  # 그룹 bfs
visited = [[0] * (1 << N) for _ in range(1 << N)]
for r in range(1 << N):
    for c in range(1 << N):
        if visited[r][c]:
            continue
        if not arr[r][c]:  # 얼음 없으면
            continue

        cnt_ice.append(bfs(r, c, len(cnt_ice)))

# 정답 출력
print(sum_ice)
print(max(cnt_ice))
