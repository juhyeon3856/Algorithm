n, m = map(int, input().split())

data = [input() for _ in range(n)]
form = ['WB'*25, 'BW'* 25] * 25
count = [[0] * m for _ in range(n)]

rowCount = 0
for j in range(m):
    if(form[0][j] == data[0][j]): rowCount+= 1
    count[0][j] = rowCount

for i in range(1, n):
    rowCount = 0
    for j in range(m):
        if(form[i][j] == data[i][j]): rowCount+= 1
        count[i][j] = count[i-1][j] + rowCount

answer = 33

for i in range(7, n):
    for j in range(7, m):
        nr = i - 8
        nc = j - 8
        a = count[nr][j] if nr >= 0 else 0
        b = count[i][nc] if nc >= 0 else 0
        c = count[nr][nc] if nr >= 0 and nc >= 0 else 0
        temp = count[i][j] - a - b + c
        temp = 64 - temp if temp > 32 else temp
        answer = temp if temp < answer else answer

print(answer)