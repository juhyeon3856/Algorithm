# 풀이 : 10시 20분 ~ 25분  / 10시 47분 ~ 10시 55분
# 소요시간 : 5 + 8 = 13분

from collections import deque

N, K = map(int, input().split())
visited = [0] * 100001  # 메모리 초과가 나면 set도 고려!

queue = deque([N])
visited[N] = 1

while queue:
    q = queue.pop()
    if q == K:
        break
    for nxt in (q - 1, q + 1, q * 2):
        if 0 <= nxt < 100001:
            if visited[nxt] : continue
            queue.appendleft(nxt)
            visited[nxt] = visited[q] + 1
print(visited[K] - 1)