# 시작시간 : 10시 00분
# 일단 완탐
from collections import deque


def bfs(fs):
    result = 1

    queue = deque([fs])
    visited[fs] = fs

    while queue:
        q = queue.pop()
        for nxt in adj[q]:
            if visited[nxt] == fs:  # 이미 방문 했으면
                continue
            queue.append(nxt)
            visited[nxt] = fs
            result += 1
    return result


V, E = map(int, input().split())
adj = [[] for _ in range(V + 1)]
visited = [0] * (V + 1)

for _ in range(E):
    e, s = map(int, input().split())  # B -> A이므로
    adj[s].append(e)

ans = []
mx = 0
visited = [0] * (V + 1)
for start in range(1, V + 1):
    cnt = bfs(start)
    if mx < cnt:  # cnt가 더 크면
        mx = cnt  #
        ans = [start]
    elif mx == cnt:  # 최댓값과 같으면
        ans.append(start)  # 정답 후보에 올림

ans.sort
print(*ans)
