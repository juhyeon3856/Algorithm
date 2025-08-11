# 점화식 : f(n) = f(n-1) + f(n-2) 단, n>=2
# 초기값 : f(0) = 0, f(1) = 1

# 한번에 입력받기
import sys
inputs = sys.stdin.read().strip().split("\n")

dp = [1, 1]  # 초기값

for line in inputs:
    # 입력
    N = int(line)
    si = len(dp)    # dp 값 있는건 굳이 다시 안만들어도 괜찮음
    
    # 로직
    for i in range(si, N + 1):
        dp.append(dp[i - 1] + 2 * dp[i - 2])

    # 정답 출력
    print(dp[N])