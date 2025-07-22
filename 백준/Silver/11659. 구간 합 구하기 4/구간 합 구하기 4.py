import sys
input = sys.stdin.readline

N, M = map(int, input().split())
arr = list(map(int, input().split()))
sumArr = [0]*(N+1)

for i in range(N):
    sumArr[i+1] = sumArr[i] + arr[i]

for i in range(M):
    s, e = map(int, input().split())
    print(sumArr[e] - sumArr[s-1])