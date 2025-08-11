# 전략
# dp1[i] := 한칸 뛰어서 i번째 계단에 왔을 때 가잘 수 있는 최대 점수
# dp2[i] := 두칸 뛰어서 i번째 계단에 왔을 때 가잘 수 있는 최대 점수
# 즉, [A] dp1[i] = dp2[i-1] + lst[i] / [B] dp2[i] = max(dp1[i-2], dp2[i-2]) + lst[i]
# [C] 초기값 :=  dp1[0] = dp2[0] = 0 = lst[0] / dp1[1] = dp2[1] = lst[1]

N = int(input())
lst = [0] + [int(input()) for _ in range(N)]
dp1, dp2 = [0] * (N + 1), [0] * (N + 1)
dp1[1] = dp2[1] = lst[1]  # ...[C]

for i in range(2, N + 1):
    dp1[i] = dp2[i - 1] + lst[i]  # ...[A]
    dp2[i] = max(dp1[i - 2], dp2[i - 2]) + lst[i]  # ...[B]

print(max(dp1[N], dp2[N]))