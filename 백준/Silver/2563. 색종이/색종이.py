arr = [[0] * 100 for _ in range(100)]

N = int(input())
for _ in range(N):
    r, c = map(int, input().split())
    for i in range(10):
        arr[r + i][c:c + 10] = [1] * 10

# 이중 리스트 출력 방법 및 더하는 방법
# print(*arr, sep="\n")
print(sum(sum(arr, [])))