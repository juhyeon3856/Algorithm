def perm(depth, cur, start, flag):
    if depth == N:
        if arr[cur][start] == 0:
            return INF
        return arr[cur][start]  # 다시 start로 돌아가는 비용
    if dp[flag][cur] != -1:  # 저장된 값 있으면
        return dp[flag][cur]
    dp[flag][cur] = INF
    for i in range(N):
        if flag & (1 << i): continue  # 이미 방문했으면 안감
        if arr[cur][i] == 0: continue  # 갈 수 없으면
        nxt = perm(depth + 1, i, start, flag | (1 << i))
        dp[flag][cur] = min(nxt + arr[cur][i], dp[flag][cur])
    return dp[flag][cur]


INF = float('inf')
N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]
dp = [[-1] * N for _ in range(1 << N)]  # visited(r)가 같을 때 c -> 1로 가는 최솟값
print(perm(1, 0, 0, 1 << 0))