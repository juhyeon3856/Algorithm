# 아이디어
# bfs거리 계산

V = int(input())
S, G = map(int, input().split())
E = int(input())
adj = [[] for _ in range(V+1)]
visited = [0] * (V+1)

for _ in range(E):
    a, b = map(int, input().split())
    adj[a].append(b)
    adj[b].append(a)    # 양방향

ans = -1
# 입력 완료! 로직 시작!
from collections import deque

queue = deque([S])
visited[S] = 1

while queue:
    q = queue.pop()
    # if q == G:
    #     ans = visited[G] - 1
    #     break
    for nxt in adj[q]:
        if visited[nxt]:
            continue
        if nxt == G:
            ans = visited[q]
            queue.clear()
            break
        queue.appendleft(nxt)
        visited[nxt] = visited[q] + 1

print(ans)