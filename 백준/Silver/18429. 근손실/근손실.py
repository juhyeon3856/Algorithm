# flag(144ms)와 visited차이 보기
N, K = map(int, input().split())

arr = list(map(lambda x: int(x) - K, input().split()))


def perm(depth, tot, flag):
    if tot < 0:
        return
    if depth == N:
        ans[0] += 1
        return
    for i in range(N):
        if visited[i]: continue
        visited[i] = 1
        perm(depth + 1, tot + arr[i], flag | 1 << i)
        visited[i] = 0


ans = [0]
visited = [0] * N
perm(0, 0, 0)
print(ans[0])