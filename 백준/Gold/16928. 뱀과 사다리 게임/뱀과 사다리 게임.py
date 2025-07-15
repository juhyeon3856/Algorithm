import heapq

n, m = map(int, input().split())
snake = [-1] * 101
ladder = [-1] * 101
dd = [1, 2, 3, 4, 5, 6]

for _ in range(n):
    s, e = map(int, input().split())
    snake[s] = e

for _ in range(m):
    s, e = map(int, input().split())
    ladder[s] = e

visited = [100] * 101
visited[1] = 0 

queue = []
heapq.heappush(queue, (0, 1))

while queue:
    cw, ci = heapq.heappop(queue)
    for d in dd:
        # ci에서 주사위를 던져서 갈 수 있는 다음 값 ni
        ni = ci + d
        if ni > 100: continue
        if snake[ni] != -1: ni = snake[ni]
        if ladder[ni] != -1: ni = ladder[ni]

        # ni에 nw = cw + 1번만에 갈 수 있음.
        # 이때 nw이 기존에 갈 수 있는 값보다 작으면 갱신
        nw = cw + 1
        if visited[ni] > nw:
            visited[ni] = nw
            heapq.heappush(queue, (nw, ni))

print(visited[100])