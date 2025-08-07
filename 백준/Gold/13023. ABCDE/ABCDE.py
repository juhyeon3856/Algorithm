N, M = map(int, input().split())
cnt_friend = [0] * N

adj = [[] for _ in range(N)]

for _ in range(M):
    a, b = map(int, input().split())
    cnt_friend[a] += 1
    cnt_friend[b] += 1
    adj[a].append(b)
    adj[b].append(a)


def dfs(depth, prev):
    if depth >= 5:
        ans[0] = 1
        return
    for nxt in adj[prev]:
        if visited[nxt]: continue
        visited[nxt] = 1
        dfs(depth + 1, nxt)
        visited[nxt] = 0


ans = [0]
visited = [0] * N
for i in range(N):
    visited[i] = 1
    dfs(1, i)
    visited[i] = 0
    if ans[0]: break
print(ans[0])

# 입력 완료! 로직 시작!
# 깊이 우선으로 가야함 -> 망...
# cnt_friend가 1인 것만 보면서 bfs돌아간다.
# from collections import deque
# def bfs(s):
#     queue = deque([s])
#     visited = [0] * N
#     visited[s] = 1
#     result = 0  # 가장 긴 길이
#
#     while queue:
#         size = len(queue)
#         result += 1
#         if result == 5:
#             return True
#         for _ in range(size):
#             q = queue.popleft()
#             for nxt in adj[q]:
#                 if visited[nxt]: continue
#                 queue.append(nxt)
#                 visited[nxt] = 1
#     return False


# bfs흔적...
# for i in range(N):
# if cnt_friend[i] != 1: continue
# if bfs(i):
#     print(1)
#     break
# else:
#     print(0)