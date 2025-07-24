N, M = map(int, input().split())

arr = [0] * (N+1)

for _ in range(M):
    i, j, k = map(int, input().split())
    for d in range(i, j+1):
        arr[d] = k

arr.remove(0)
print(*arr)