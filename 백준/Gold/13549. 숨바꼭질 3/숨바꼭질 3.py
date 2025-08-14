from collections import deque


def bfs():
    queue = deque([(N, 0)])

    while queue:
        cur, cw = queue.popleft()

        if visited[cur]:
            continue
        visited[cur] = 1

        if cur == K:
            return cw

        # 순간이동 -> 가중치 0 -> 앞에서 넣기
        nxt = cur * 2
        if nxt < 0 or nxt > 100_000:
            pass
        else:
            queue.appendleft((nxt, cw))

        # +-1 이동 -> 가중치 1 -> 뒤에서 넣기
        for nxt in (cur + 1, cur - 1):
            if nxt < 0 or nxt > 100_000:
                continue
            queue.append((nxt, cw + 1))


N, K = map(int, input().split())

if N >= K:  # K 가 더 왼쪽이면 순간이동 못씀
    print(N - K)
else:
    visited = [0] * 100_001

    # 정답출력
    print(bfs())  # 0-1 bfs로 탐색 (순간이동 : 가중치0, +-1 : 가중치1)