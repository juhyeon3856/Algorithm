N, M = map(int, input().split())
Queen = list(map(int, input().split()))
Knight = list(map(int, input().split()))
Pawn = list(map(int, input().split()))
board = [[0] * M for _ in range(N)]
visited = [[0] * M for _ in range(N)]  # 안전하지 않은 영역 1

# 데이터 처리
Q = [[Queen[i] - 1, Queen[i + 1] - 1] for i in range(1, Queen[0] * 2 + 1, 2)]
K = [[Knight[i] - 1, Knight[i + 1] - 1] for i in range(1, Knight[0] * 2 + 1, 2)]
P = [[Pawn[i] - 1, Pawn[i + 1] - 1] for i in range(1, Pawn[0] * 2 + 1, 2)]

# board에 표시!
for r, c in Q:
    board[r][c] = 'Q'
    visited[r][c] = 1

for r, c in K:
    board[r][c] = 'K'
    visited[r][c] = 2

for r, c in P:
    board[r][c] = 'P'
    visited[r][c] = 3

# 안전하지 않은 구역 체크

# Queen
dr = [-1, -1, 0, 1, 1, 1, 0, -1]
dc = [0, 1, 1, 1, 0, -1, -1, -1]
for r, c in Q:
    for d in range(8):
        nr, nc = r + dr[d], c + dc[d]
        while 0 <= nr < N and 0 <= nc < M and not board[nr][nc]:  # 장애물 없는동안
            visited[nr][nc] = 11
            nr += dr[d]
            nc += dc[d]

a = 0

# Knight
dr = [-2, -2, -1, 1, 2, 2, 1, -1]
dc = [-1, 1, 2, 2, 1, -1, -2, -2]
for r, c in K:
    for d in range(8):
        nr, nc = r + dr[d], c + dc[d]
        if 0 <= nr < N and 0 <= nc < M and not board[nr][nc]:  # 장애물 없는동안
            visited[nr][nc] = 22

ans = 0
for r in range(N):
    for c in range(M):
        if visited[r][c]:
            continue
        ans += 1

print(ans)