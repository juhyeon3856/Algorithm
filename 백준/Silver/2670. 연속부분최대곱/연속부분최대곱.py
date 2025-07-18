import sys

input = sys.stdin.readline

N = int(input())
answer = 0
dp = 0

for i in range(N):
  num = float(input())
  dp = max(dp*num, num)
  answer = max(answer, dp)

print(f"{answer:.3f}")