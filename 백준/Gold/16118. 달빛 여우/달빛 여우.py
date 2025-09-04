# test = 2
# for i in range(100000000):
#     result = False
#     if i % 2 == 0 and test != 2:
#         print(i)
#     elif i % 2 == 1 and test != (2**-1):
#         print(i)
#     test **= -1
from heapq import heappush, heappop
import sys

input = sys.stdin.readline

# 입력
N, M = map(int, input().split())  # 노드, 간선
# edges = [list(map(int, input().split())) for _ in range(M)]

# [전처리1] 인접 리스트 만들기
adj = [[] for _ in range(N + 1)]  # 어디를, 길이는

for _ in range(M):
    a, b, d = map(int, input().split())
    adj[a].append((b, d))
    adj[b].append((a, d))

# [전처리2] 결과 저장할 여우, 늑대 거리 최솟값 리스트 만들기
INF = 4000 * 100000 * 100
dist_fox = [[0]] + [[0]] + [[INF] * (N + 1)]
dist_wolf = [[0]] + [[INF] * (N + 1)] + [[0]] + [[0]] + [[INF] * (N + 1)]

delta_fox = [0, 2, 2]
delta_wolf = [0, 1, 4]


# 로직
def dijkstra(dist, pq, delta):
    while pq:
        cw, cd, cn = heappop(pq)

        if dist[delta[-cd]][cn] < cw:
            continue

        for nn, nw in adj[cn]:
            if dist[delta[cd]][nn] > cw + nw * delta[cd]:
                dist[delta[cd]][nn] = cw + nw * delta[cd]
                heappush(pq, (cw + nw * delta[cd], -cd, nn))


# 여우
pq_fox = [(0, 1, 1)]  # 거리합, 속도, 현위치
dist_fox[2][1] = 0
dijkstra(dist_fox, pq_fox, delta_fox)

# 늑대
pq_wolf = [(0, 1, 1)]  # 거리합, 속도, 현위치
# dist_wolf[1][1] = 0
dist_wolf[4][1] = 0
dijkstra(dist_wolf, pq_wolf, delta_wolf)

# 정답처리
ans = 0
for i in range(1, N + 1):
    if dist_fox[2][i] < min(dist_wolf[1][i], dist_wolf[4][i]):
        ans += 1
print(ans)