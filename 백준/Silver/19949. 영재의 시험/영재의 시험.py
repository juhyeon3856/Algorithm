def perm(depth, pprev, prev, score):  # depth, 전전, 전
    if N - depth + score < 5:
        return
    if depth == N:
        if score >= 5:
            ans[0] += 1
        return
    for i in (1, 2, 3, 4, 5):
        if prev != i:
            perm(depth + 1, prev, i, score + (lst[depth] == i))
        else:
            if pprev != i:
                perm(depth + 1, prev, i, score + (lst[depth] == i))


N = 10
lst = list(map(int, input().split()))
ans = [0]


perm(0, 0, 0, 0)
print(ans[0])