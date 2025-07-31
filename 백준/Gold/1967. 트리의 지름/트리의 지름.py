# 풀이 시작 8시 15분 끝 8시 32분
# 소요시간 17분

# 자식 노드만 가는걸로 푸르닝 안했으면 시간 터지는지 TEST

# 아이디어
# 자식 노드에서 시작하는 모든 경우의 수 고려
# bfs롤 통해 자식 노드에서 가장 가중치 큰 노드를 계산(갈 수 있는곳 다 감)

from collections import deque

N = int(input())
adj = [[] for _ in range(N + 1)]  # 노드 1번부터 시작


def max_len(fsn):
    result = 0  # 갈 수 있는 최대 길이
    visited = [0] * (N + 1)
    queue = deque([[fsn, 0]])
    visited[fsn] = -1

    while queue:
        cn, cw = queue.popleft()
        result = max(result, cw)  # 가중치 최댓값 갱신
        for nn, nw in adj[cn]:
            if visited[nn]:  # 이미 방문 했으면
                continue
            queue.append([nn, cw + nw])
            visited[nn] = 1
    return result


for _ in range(N - 1):  # 간선 N-1개
    s, e, w = map(int, input().split())
    adj[s].append([e, w])  # 양방향
    adj[e].append([s, w])

ans = 0
for sn in range(1, N + 1):  # 노드 하니씩 시작노드
    if len(adj[sn]) > 1: continue  # 자식이 있으면 continue
    ans = max(ans, max_len(sn))

print(ans)