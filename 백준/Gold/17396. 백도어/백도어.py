# 입력
N, M = map(int, input().split())

alst = list(map(int, input().split()))
alst[N - 1] = 0

INF = float("inf")
dist = [INF] * N

adj = [[] for _ in range(N)]

# arr = [list(map(int, input().split())) for _ in range(M)]

for _ in range(M):
    a, b, t = map(int, input().split())
    adj[a].append((b, t))
    adj[b].append((a, t))

# 로직 시작! 다익스트라

from heapq import heappop, heappush

pq = [(0, 0)]  # w, idx
ans = -1

while pq:
    cw, ci = heappop(pq)

    if cw > dist[ci]:  # 두번째 방문
        continue

    if ci == N - 1:  # 정답
        ans = cw
        break

    for ni, nw in adj[ci]:
        if alst[ni]:
            continue
        if dist[ni] > cw + nw:
            dist[ni] = cw + nw
            heappush(pq, (dist[ni], ni))
    debug = 0

print(ans)