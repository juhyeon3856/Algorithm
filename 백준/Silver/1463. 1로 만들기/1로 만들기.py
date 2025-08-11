# 입력
N = int(input())

dp = [-1, 0, 1, 1] + [-1] * (N - 3)  # i는 1을 만들기위해 dp[i]번 해야함 (-1은 불가능)
for i in range(4, N + 1):
    dp[i] = dp[i - 1] + 1  # 1을 뺀다
    if i % 2 == 0: dp[i] = dp[i] if dp[i] < dp[i // 2] + 1 else dp[i // 2] + 1  # 2로 나눈다
    if i % 3 == 0: dp[i] = dp[i] if dp[i] < dp[i // 3] + 1 else dp[i // 3] + 1  # 3으로 나눈다

print(dp[N])  # 정답 출력