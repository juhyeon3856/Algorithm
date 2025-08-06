N, K = map(int, input().split())

arr = [list(map(int, input().split())) for _ in range(N)]
lst = [0] * N
for i in range(N):
    lst[i] = arr[i][1] - arr[i][0]

# 입력 및 전처리 완료!

lst.sort()
print(max(0, lst[K - 1]))