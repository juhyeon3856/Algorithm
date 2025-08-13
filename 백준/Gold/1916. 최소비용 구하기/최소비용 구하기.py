# 다익스트라

from heapq import heappop, heappush

# 입력
N = int(input())
M = int(input())
arr = [list(map(int, input().split())) for _ in range(M)]
si, ei = map(int, input().split())

# 전처리
adj = [[] for _ in range(N + 1)]  # 1번부터 N번까지 사용
for s, e, w in arr:
    adj[s].append((e, w))

INF = 100_000 * 1_000 * 100
pq = [(0, si)]
dist = [INF] * (N + 1)  # 거리 저장
dist[si] = 0
visited = [0] * (N + 1)

# 로직

while pq:
    # 최소 인덱스 찾기
    pw, pi = heappop(pq)

    # if visited[pi]:
    #     continue
    # visited[pi] = 1

    if pi == ei:  # 가장 먼저 나온 ei가 최소 시간
        print(pw)  # 정답 출력
        break  # 종료

    # 최소 인덱스를 경유지로 가는 경우 갱신
    for ni, nw in adj[pi]:
        if pw + nw < dist[ni]:  # 경유지 들리는게 더 최소면
            dist[ni] = pw + nw  # 최소 갱신
            heappush(pq, (pw + nw, ni))  # pq에 넣기 -> 빠른게 먼저 나올 것임