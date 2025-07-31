# 풀이 : 11:42 ~

# 아이디어
# 인접리스트 & bfs

from collections import deque

T = int(input())
for t in range(1, T + 1):
    N = int(input())
    arr = [list(map(int, input().split())) for _ in range(N + 2)]
    visited = [0] * (N + 2)
    adj = [[] for _ in range(N + 2)]  # 0번 인덱스 start

    # 인접리스트 만들기 ( 50 * 20 보다 작으면 이동할 수 있음 == adj에 추가 )
    for i in range(N + 2):
        for j in range(N + 2):
            if i == j: continue
            if abs(arr[i][0] - arr[j][0]) + abs(arr[i][1] - arr[j][1]) <= 1000:
                adj[i].append(j)
                adj[j].append(i)  # 양방향

    ans = 'sad'
    queue = deque([0])
    visited[0] = 1

    while queue:
        q = queue.pop()

        # 종료조건
        if q == N + 1:
            ans = "happy"
            break

        for nxt in adj[q]:
            if visited[nxt]:
                continue
            queue.appendleft(nxt)
            visited[nxt] = 1

    print(ans)
