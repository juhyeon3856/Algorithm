from collections import deque

# 입력
N, M = map(int, input().split())
arr = [list(input()) for _ in range(N)]
T = int(input())
cmds = list(map(int, input().split()))


# 함수들 ------------------
def throw(r, s, e, d):
    for c in range(s, e, d):
        if arr[r][c] == mineral:
            arr[r][c] = blank
            return


queue = deque()
dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]
mineral = 'x'
blank = '.'


def check(r, c):
    return 0 <= r < N and 0 <= c < M


def make_group(r, c, ttype):
    queue.append((r, c))
    visited[r][c] = ttype
    result = 1

    while queue:
        cr, cc = queue.popleft()
        for d in range(4):
            nr, nc = cr + dr[d], cc + dc[d]
            if nr >= N:  # 바닥에 닿으면
                result = 0
            if not check(nr, nc):
                continue
            if visited[nr][nc] == ttype:
                continue
            if arr[nr][nc] == blank:
                continue
            queue.append((nr, nc))
            visited[nr][nc] = ttype

    return result


def can_down(lst, delta):
    # 바닥에 닿으면 못내려감
    # 다른 미네랄 만나도 못내려감

    for r, c in lst:
        r += delta
        if not check(r, c):
            return False
        if arr[r][c] == mineral:
            return False
    return True


def write_block(lst, delta, value):
    for r, c in lst:
        r += delta
        arr[r][c] = value


# 로직 -------------------
for i in range(T):
    # [1] 활 던지기
    if i % 2 == 0:
        throw(N - cmds[i], 0, M, 1)
    else:
        throw(N - cmds[i], M - 1, -1, -1)

    # [2] 분리되어있는지 확인
    visited = [[0] * M for _ in range(N)]
    group_info = [0]  # 바닥이랑 붙어있으면 0, 아니면 1 -> 1은 떨어져야함!
    for gr in range(N):
        for gc in range(M):
            if arr[gr][gc] == blank:
                continue
            if visited[gr][gc] == 0:
                group_info.append(make_group(gr, gc, len(group_info)))

    # [3] 떨어뜨리기
    # [3-1] 체크리스트 만들기
    check_lst = []
    move_lst = []
    for gr in range(N - 1):
        for gc in range(M):
            if group_info[visited[gr][gc]] == 0:
                continue  # 안내려도 됌
            move_lst.append((gr, gc))
            if arr[gr + 1][gc] == mineral:
                continue
            check_lst.append((gr + 1, gc))

    if not move_lst:
        continue
    # 지우고 다시 그리기
    cnt = 0
    while can_down(check_lst, cnt):  # 바닥이나 다른 미네랄 만날때까지
        write_block(move_lst, cnt, blank)
        write_block(move_lst, cnt + 1, mineral)
        cnt += 1

for ans in arr:
    print(*ans, sep='')
