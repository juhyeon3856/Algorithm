r = -1
c = -1
m = -1

for i in range(9):
    data = list(map(int, input().split()))
    for j in range(9):
        if m < data[j]:
            m = data[j]
            r = i+1
            c = j+1

print(m)
print(r, c)