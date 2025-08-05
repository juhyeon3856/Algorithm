from collections import deque

N, M = map(int, input().split())
adj = [[] for _ in range(N + 1)]

# 인접리스트 만들기
for _ in range(M):
    a, b = map(int, input().split())
    adj[a].append(b)
    adj[b].append(a)  # 양방향


def find():     # N+M
    result = [-1] * (N + 1)  # 각 도시별, 최소 방문 도시 수 (visited로 사용)
    queue = deque([1])
    result[1] = 0

    while queue:
        cur = queue.popleft()
        for nxt in adj[cur]:
            if result[nxt] > -1:  # 이미 방문한 적 있으면
                continue
            queue.append(nxt)
            result[nxt] = result[cur] + 1
    return result[1:]


Q = int(input())
for _ in range(Q):      # 500
    a, b = map(int, input().split())
    adj[a].append(b)
    adj[b].append(a)  # 다리 양방향 연결
    print(*find())