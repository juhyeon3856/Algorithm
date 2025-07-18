import sys

# input = sys.stdin.readline

N = int(input())
answer = 0
data = [float(input()) for _ in range(N)]

def sol(s, e):
  n = e-s
  maxList = [0] * (N+2)
  minList = [1] * (N+2)
  multList = [1] * (N+1)
  result = 0
  for i in range(s, e):
    multList[i+1] = multList[i] * data[i]

  for i in range(e, s, -1):
    maxList[i] = max(multList[i], maxList[i+1])

  for i in range(s+1, e+1):
    minList[i] = min(multList[i], minList[i-1])

  for i in range(s+1, e+1):
    result = max(result, maxList[i]/minList[i-1])
  
  return round(result, 3)

s = 0
for i in range(N):
  if data[i] == 0:
    if(s < i): answer = max(answer, sol(s, i))
    s = i+1
if s < N : answer = max(answer, sol(s,N))
  
print(f"{answer:.3f}")