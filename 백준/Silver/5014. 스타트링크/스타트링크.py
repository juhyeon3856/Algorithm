from collections import deque

F, S, G, U, D = map(int, input().split())

inf = F*2
visited = [inf] * (F+1)

queue = deque([S])
visited[S] = 0

ans = "use the stairs"
while queue:
    q = queue.popleft()
    if q == G:
        ans = visited[G]
        break
    for d in (U, -D):
        nxt = q + d
        if nxt > F or nxt < 1:  # 갈수 없는 층
            continue
        if visited[nxt] < inf:  # 방문함
            continue
        visited[nxt] = visited[q] + 1
        queue.append(nxt)

print(ans)