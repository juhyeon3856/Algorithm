def dfs(depth, bcnt, flag, m):  # depth == start_idx의 index, bcnt : 비숍 개수
    if m - depth + bcnt <= ans[0]:  # 남은 곳에 다 놓아도 max갱신 못하면
        return  # 푸르닝
    if depth == m:
        ans[0] = max(ans[0], bcnt)
        return
    cr, cc, st = start_idx[depth]
    for i in range(st):
        nr, nc = cr + i, cc + i
        if arr[nr][nc]:  # 비숍 놓을 수 있는데
            if not (flag & 1 << (nr + nc)):  # 대각선에 비숏 이미 놓아져있지 않으면
                dfs(depth + 1, bcnt + 1, flag | 1 << (nr + nc), m)
        dfs(depth + 1, bcnt, flag, m)



N = int(input())
M = 2 * N - 1
arr = [list(map(int, input().split())) for _ in range(N)]
ans = [0, 0]
start_idx = [(0, 0, N)]
for i in range(2, N, 2):
    start_idx.append((0, i, N - i))
    start_idx.append((i, 0, N - i))
dfs(0, 0, 0, N - (N+1) % 2)
ans[0], ans[1] = 0, ans[0]

start_idx = []
for i in range(1, N, 2):
    start_idx.append((0, i, N - i))
    start_idx.append((i, 0, N - i))
dfs(0, 0, 0, N - N % 2)

# diag = [0] * M
print(ans[0] + ans[1])
