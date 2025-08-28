N, M = map(int, input().split())

arr = [list(map(int, input().split())) for _ in range(N)]


class Node:
    def __init__(self, r, c, v):
        self.r = r
        self.c = c
        self.v = v

    def __repr__(self):
        return f"(r: {self.r}, c: {self.c}, v: {self.v})"


lst = []
for r in range(N):
    _lst = []

    for c in range(M):
        _lst.append(Node(r, c, arr[r][c]))

    if r % 2 == 0:
        lst.extend(_lst)
    else:
        lst.extend(_lst[::-1])

# print(*lst)

ans = []

for i in range(1, N * M - 1):
    p, n, nn = lst[i - 1], lst[i], lst[i + 1]

    if p.v == 0:
        continue

    if p.v <= n.v:
        ans.append((p.r + 1, p.c + 1, n.r + 1, n.c + 1, -p.v))
        n.v = n.v - p.v
    else:
        ans.append((n.r + 1, n.c + 1, nn.r + 1, nn.c + 1, p.v - n.v))
        nn.v = nn.v + p.v - n.v
        ans.append((p.r + 1, p.c + 1, n.r + 1, n.c + 1, -p.v))
        n.v = 0

p, n = lst[-2], lst[-1]
if p.v == n.v:
    ans.append((p.r + 1, p.c + 1, n.r + 1, n.c + 1, -p.v))
    print(len(ans))
    for aans in ans:
        print(*aans)
else:
    print(-1)

# print(*lst)
