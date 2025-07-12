n = int(input())
data = [False] * 2001
for _ in range(n):
    data[int(input())+1000] = True

for i in range(2001):
    if(data[i]): print(i-1000)