N, r, c = map(int, input().split())
sr, sc = 0, 0
ans = 0

while N > 0:
    m = 1 << (N - 1)
    if r < sr + m and c < sc + m:
        pass
    elif r < sr + m:
        sc = sc + m
        ans += m * m
    elif c < sc + m:
        sr = sr + m
        ans += m * m * 2
    else:
        sr, sc = sr + m, sc + m
        ans += m * m * 3
    N -= 1

print(ans)