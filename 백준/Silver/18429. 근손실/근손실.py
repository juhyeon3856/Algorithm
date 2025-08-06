N, K = map(int, input().split())

arr = list(map(lambda x: int(x) - K, input().split()))


def perm(depth, tot, flag):
    if tot < 0:
        return
    if depth == N:
        ans[0] += 1
        return
    for i in range(N):
        if flag & 1 << i: continue
        perm(depth + 1, tot + arr[i], flag | 1 << i)


ans = [0]
perm(0, 0, 0)
print(ans[0])