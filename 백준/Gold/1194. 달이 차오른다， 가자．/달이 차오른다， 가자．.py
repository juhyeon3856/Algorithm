from collections import deque

tra = {'A': 0, 'B': 1, 'C': 2, 'D': 3, 'E': 4, 'F': 5, 'a': 0, 'b': 1, 'c': 2, 'd': 3, 'e': 4, 'f': 5}
dset = {'A', 'B', 'C', 'D', 'E', 'F'}
kset = {'a', 'b', 'c', 'd', 'e', 'f'}

dr = [-1, 1, 0, 0]
dc = [0, 0, 1, -1]


def check(r, c):
    return 0 <= r < N and 0 <= c < M


N, M = map(int, input().split())

board = [list(input()) for _ in range(N)]
visited = [[[0] * M for _ in range(N)] for _ in range(64)]  # 0은 키 없음

for r in range(N):
    for c in range(M):
        if board[r][c] == '0':
            sr, sc = r, c
            board[r][c] = '.'
        # if board[r][c] == '1':
        #     er, ec = r, c
        #     board[r][c] = '.'

queue = deque([(sr, sc, 0)])
visited[0][sr][sc] = 1

ans = -1

while queue:
    cr, cc, ck = queue.popleft()

    # 정답 체크
    if board[cr][cc] == '1':
        ans = visited[ck][cr][cc] - 1
        break

    for d in range(4):
        nr, nc, nk = cr + dr[d], cc + dc[d], ck

        if not check(nr, nc):  # 범위
            continue

        nxt = board[nr][nc]
        if nxt == '#':  # 벽
            continue

        if visited[nk][nr][nc]:  # 이미 갔으면
            continue

        if nxt in dset:  # 문이면
            if ck & (1 << tra.get(nxt)) == 0:  # 키 없으면
                continue

        if nxt in kset:
            nk = ck | (1 << tra.get(nxt))  # 키 갱신, 기존 키 조합 갈 필요 없음(손해)

        queue.append((nr, nc, nk))  # 들어감
        visited[nk][nr][nc] = visited[ck][cr][cc] + 1  # 이번 키 조합으로는 갔음

print(ans)
