# 시작시간 7시 40분

# 아이디어
# 8방에 지뢰가 없는 칸을 찾음
# 그 칸들을 한 그룹으로 묶어서 한번에 열기
# a = 묶어진 그룹 수(한방에 열리는) (cnt_zero)
# b = 그룹마다 열린 개수의 총 합 (cnt_open)
# c = 지뢰 개수 (cnt_bomb)
# 정답 = a + (N*N - b - c)

from collections import deque

T = int(input())
dr = [1, -1, 0, 0, 1, 1, -1, -1]
dc = [0, 0, 1, -1, 1, -1, -1, 1]


def check(fr, fc):
    return 0 <= fr < N and 0 <= fc < N


for t in range(1, T + 1):

    # 입력
    N = int(input())
    arr = [list(input()) for _ in range(N)]

    # 전처리
    cnt = [[0] * N for _ in range(N)]  # r, c의 8방에 있는 지뢰 개수
    cnt_bomb = 0

    for r in range(N):
        for c in range(N):
            if arr[r][c] == '*':  # 폭탄이면
                cnt_bomb += 1
                cnt[r][c] = -1
            else:  # 폭탄 아니면
                for d in range(8):
                    nr, nc = r + dr[d], c + dc[d]
                    if not check(nr, nc):
                        continue
                    if arr[nr][nc] == '*':
                        cnt[r][c] += 1

    # 로직1 : 0인 부분을 찾아 bfs를 돌리면서 클릭 한번으로 열어지는 개수를 센다.
    visited = [[0] * N for _ in range(N)]
    cnt_zero, cnt_open = 0, 0
    queue = deque([])

    for r in range(N):
        for c in range(N):
            if visited[r][c]:  # 이미 열었으면
                continue
            if cnt[r][c]:  # 8방에 폭탄이 있으면
                continue
            cnt_zero += 1

            # r, c에서 시작하는 bfs돌리기
            queue.append((r, c))
            visited[r][c] = 1
            cnt_open += 1

            while queue:
                cr, cc = queue.popleft()
                for d in range(8):
                    nr, nc = cr + dr[d], cc + dc[d]
                    if not check(nr, nc):  # 범위 밖이면
                        continue
                    if visited[nr][nc]:  # 이미 방문했으면
                        continue

                    visited[nr][nc] = 1  # 방문처리
                    cnt_open += 1
                    if cnt[nr][nc] == 0:
                        queue.append((nr, nc))
            ### bfs끝!#########

    ans = N * N - cnt_open - cnt_bomb + cnt_zero
    print(f"#{t} {ans}")
