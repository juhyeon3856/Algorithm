# 입력
N = int(input())
lst = list(map(int, input().split()))

## 풀이1 #################
# dp[i]는 i번째 수를 포함하는 경우 가장 큰 누적값을 적어둔다
# [A] 즉, dp[i] = max(본인부터 다시 시작 vs 앞에 누적값에 본인 더함)

# dp = [0]  # 처음 값을 위해 초기값 넣어주기 -> 정답 시 제외해주기**
#
# for num in lst:
#     dp.append(max(dp[-1] + num, num))  # ...[A]
#
# print(max(dp[1:]))  # 정답 출력

## 풀이2 ###########
# dp배열에서 직전 값 이외에 사용하지 않음
# [B] 따라서 dp[-1]대신 dp라는 변수를 만들어서 사용
# [C] 매번 ans에 max갱신
ans, dp = -float("inf"), 0

for num in lst:
    dp = dp + num if dp + num > num else num  # ...[B]
    ans = ans if ans > dp else dp  # ...[C]

print(ans)