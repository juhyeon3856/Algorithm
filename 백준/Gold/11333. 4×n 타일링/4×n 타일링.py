# 점화식 : dp[i] = 5*dp[i-1] - 3*dp[i-2] + dp[i-3]
# 초기값 : dp[1] = 3, dp[2] = 13, dp[3] = 57
# 만들지 못하는 경우(3의 배수가 아닐 때 : 0)

T = int(input())
dp = [1, 3, 13, 57]
for _ in range(T):
    N = int(input())
    if N % 3 == 0:
        N //= 3
    else:
        print(0)
        continue
    start = len(dp)
    for i in range(start, N + 1):
        dp.append((5 * dp[i - 1] - 3 * dp[i - 2] + dp[i - 3]) % 1_000_000_007)
    print(dp[N])