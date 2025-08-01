st = "-" + input()
N = len(st)
ans = 0
for i in range(1, N):
    if st[i] == st[i - 1]:  # 다르면
        ans += 5
    else:
        ans += 10
print(ans)