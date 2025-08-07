# 아이디어
# 25C7 & bfs(7명 연결되어있는지 확인)
from collections import deque

N, M, R = 5, 25, 7
arr = [list(input()) for _ in range(N)]
ans = [0]


def combi(depth, start, nums):  # nums : 7명 뽑은거 넣어둠
    if depth == R:
        if cnt_s(nums) and is_ans(nums):  # 7명이 연결되어있으면
            ans[0] += 1
        return
    for i in range(start, M):
        combi(depth + 1, i + 1, nums | {i})


dr = [0, 0, 1, -1]
dc = [1, -1, 0, 0]


def cnt_s(select):
    s = 0
    for n in select:
        if arr[n // N][n % N] == 'S':
            s += 1
    if s >= 4:
        return True
    else:
        return False


def is_ans(select):
    queue = deque([select.pop()])  # 처음 친구

    while queue:
        q = queue.popleft()
        for d in range(4):
            nr, nc = q // N + dr[d], q % N + dc[d]
            if 0 <= nr < N and 0 <= nc < N:
                nxt = nr * N + nc
                if nxt in select:
                    select.remove(nxt)
                    queue.append(nxt)
    if select:
        return False
    else:
        return True


combi(0, 0, set())
print(ans[0])