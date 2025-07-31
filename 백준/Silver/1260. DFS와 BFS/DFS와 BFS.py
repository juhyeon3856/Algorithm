# 시작시간 : 9시 18분
# 끝난 시간 : 9시 27분
# 소요시간 : 약 9분

# 정점 번호가 작은 것을 먼저 방문

def dfs(cur):
    visited[cur] = 1
    dfs_ans.append(cur)
    for nxt in adj[cur]:
        if visited[nxt]:  # 이미 방문 했으면
            continue
        dfs(nxt)
        visited[nxt] = 1


V, E, S = map(int, input().split())
adj = [[] for _ in range(V + 1)]

for _ in range(E):
    a, b = map(int, input().split())
    adj[a].append(b)
    adj[b].append(a)  # 양방향

# 정렬
for i in range(1, V + 1):
    adj[i].sort()

# dfs
dfs_ans = []
visited = [0] * (V + 1)
dfs(S)

# bfs
bfs_ans = []
visited = [0] * (V + 1)

from collections import deque

queue = deque([S])
visited[S] = 1
bfs_ans.append(S)

while queue:
    q = queue.pop()
    for nxt in adj[q]:
        if visited[nxt]:  # 이미 방문 했으면
            continue
        queue.appendleft(nxt)
        bfs_ans.append(nxt)
        visited[nxt] = 1

print(*dfs_ans)
print(*bfs_ans)
