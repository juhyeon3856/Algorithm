N, M = map(int, input().split())

arr = [i for i in range(N + 1)]

for _ in range(M):
    a, b = map(int, input().split())
    temp = arr[a]
    arr[a] = arr[b]
    arr[b] = temp

arr.remove(0)

print(*arr)