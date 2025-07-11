n, m = map(int, input().split())

data1 = [list(map(int, input().split())) for _ in range(n)]
data2 = [list(map(int, input().split())) for _ in range(n)]
result = [[data1[i][j] + data2[i][j] for j in range(m)] for i in range(n)]

answer = ""
for row in result:
    answer += " ".join(map(str, row)) + "\n"

print(answer)