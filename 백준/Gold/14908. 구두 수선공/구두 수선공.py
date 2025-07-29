N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]

for i in range(N):
    arr[i] = [arr[i][1] / arr[i][0], i + 1]

arr.sort(key=lambda x: (-x[0], x[1]))

for i in range(N):
    print(arr[i][1], end=" ")