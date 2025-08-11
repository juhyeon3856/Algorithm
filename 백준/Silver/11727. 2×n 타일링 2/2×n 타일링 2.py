# 점화식 : f(n) = f(n-1) + f(n-2) + f(n-2) 단 , n >=2
# f(0) = 1, f(1) = 1

# 입력 및 dp배열 초기화
N = int(input())
dp = [1, 1] + [-1] * (N - 1)  # 길이 N+1인 dp배열

# dp에 값 넣기(점화식 반영)
for i in range(2, N + 1):
    dp[i] = dp[i - 1] + dp[i - 2] * 2

# 정답 출력
print(dp[N] % 10007)