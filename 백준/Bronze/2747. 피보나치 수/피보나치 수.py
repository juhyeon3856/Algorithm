# 입력
N = int(input())


# # Bottom-up
# dp = [0, 1]  # i번째 피보나치 수 저장
# for _ in range(1, N):  # N-1번 수행하면 dp[N]이 생김
#     dp.append(dp[-1] + dp[-2])  # 피보나치 수 구하기

# Top-down
def fibo(num):
    if dp[num] == -1:  # 값 없으면
        dp[num] = fibo(num - 1) + fibo(num - 2)  # 값 만들기 위한 재귀 호출
    return dp[num]


dp = [-1] * (N + 2)  # dp table만들기(0일때 1 만들어주기 위해서  N+2개 만들기)
dp[0], dp[1] = 0, 1  # 초기값
fibo(N)  # 재귀 호출

# 출력
print(dp[N])  # N번째 피보나치 수 출력
