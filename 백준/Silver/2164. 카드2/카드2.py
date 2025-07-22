import sys
input = sys.stdin.readline

n = int(input())

isUse = [False] * (n+1)

count = 0
answer = 0
flag = True
while(count < n):
  for i in range(1, n+1):
    if isUse[i]: continue
    if flag:
      isUse[i] = True
      flag = False
      answer = i
      count+=1
    else:
      flag = True

print(answer)