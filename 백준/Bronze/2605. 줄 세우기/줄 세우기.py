N = int(input())
lst = list(map(int, input().split()))

ans = [1]
for i in range(1, N):
    nxt = lst[i]
    ans = ans[:i - nxt] + [i + 1] + ans[i - nxt:]

print(*ans)
