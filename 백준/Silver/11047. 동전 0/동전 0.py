N, K = map(int, input().split())
A = [int(input()) for _ in range(N)]

answer = 0
for i in range(N-1, -1, -1):
    answer += K//A[i]
    K %= A[i]
print(answer)