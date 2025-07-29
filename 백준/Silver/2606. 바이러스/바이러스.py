def dfs(cur):
    visited[cur] = 1
    ans[0] += 1

    for nxt in adj[cur]:
        if visited[nxt]: continue
        dfs(nxt)


V = int(input())
E = int(input())

adj = [[] for _ in range(V + 1)]
visited = [0] * (V + 1)

for _ in range(E):
    a, b = map(int, input().split())
    adj[a].append(b)
    adj[b].append(a)

ans = [0]
dfs(1)

print(ans[0]-1)