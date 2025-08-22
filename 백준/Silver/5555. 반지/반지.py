# 시작시간 : 1시 15분

G = input()
N = int(input())
ans = 0
gn = len(G)

for _ in range(N):
    st = input()
    st += st
    for i in range(10):
        if G == st[i:i + gn]:
            ans += 1
            break

print(ans)