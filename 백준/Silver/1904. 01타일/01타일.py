# dp[i] := 길이가 i인 가짓수
# dp[i] = dp[i-1] + dp[i-2]
# dp[0] = 1, dp[1] = 1

N = int(input())

dp1, dp2 = 1, 1

for _ in range(2, N + 1):
    dp1, dp2 = dp2, (dp1 + dp2) % 15746

print(dp2)