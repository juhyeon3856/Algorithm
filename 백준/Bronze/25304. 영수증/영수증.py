tot = int(input())
N = int(input())
sumAll = 0

for _ in range(N):
    p, c = map(int, input().split())
    sumAll += p*c

if tot == sumAll:
    print("Yes")
else:
    print("No")