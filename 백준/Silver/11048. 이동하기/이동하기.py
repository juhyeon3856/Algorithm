# dp[r][c]는 r, c자리에 올 때 가지고 있을 수 있는 최대 사탕 개수
# [A] 즉, dp[r][c] = max(dp[r-1][c-1], dp[r][c-1], dp[r-1][c]) + arr[r][c]

# 입력
N, M = map(int, input().split())
arr = [[0] * (M + 1)] + [[0] + list(map(int, input().split())) for _ in range(N)]

# 로직
dp = [[0] * (M + 1) for _ in range(N + 1)]  # 좌측, 상단 패딩 넣어주기(범위 밖 초기값 0)
for r in range(1, N + 1):
    for c in range(1, M + 1):
        dp[r][c] = max(dp[r - 1][c - 1], dp[r][c - 1], dp[r - 1][c]) + arr[r][c]  # ...[A]

# 정답 출력
print(dp[N][M])