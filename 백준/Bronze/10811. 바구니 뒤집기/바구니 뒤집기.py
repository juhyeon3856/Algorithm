N, M = map(int, input().split())

arr = [i for i in range(N + 1)]

for _ in range(M):
    a, b = map(int, input().split())
    arr[a:b+1] = arr[b:a-1:-1]

arr.remove(0)

print(*arr)