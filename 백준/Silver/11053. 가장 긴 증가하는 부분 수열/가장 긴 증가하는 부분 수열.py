# 전략
# dp[i] := 길이가 i인 증가하는 부분수열 마지막 수(최소 갱신)

N = int(input())
lst = list(map(int, input().split()))
dp = []

for num in lst:
    for i in range(len(dp)):
        if dp[i] >= num:  # dp에서 num이 작거나 같아지는 첫 경우에
            dp[i] = num  # 값 갱신하고
            break  # 멈춤
    else:
        dp.append(num)  # 갱신 못했으면 맨 끝에 append(dp에 있는 수가 모두 자신보다 작다는 의미니까)

print(len(dp))