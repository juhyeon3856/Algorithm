# 아이디어
# bfs
# for문 돌면서 집인데 visited안간거 찾아서 bfs돌림
# bfs함수 리턴값 : 같은 구역에 있는 집 수

from collections import deque

dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]

def bfs(fr, fc):
    # 초기화
    result = 1
    queue = deque([[fr, fc]])
    visited[fr][fc] = 1

    # queue빼기
    while queue:
        q = queue.pop()
        cr, cc = q[0], q[1]
        for d in range(4):
            nr, nc = cr + dr[d], cc + dc[d]
            if 0<=nr<N and 0<=nc<N:
                if visited[nr][nc]: # 이미 방문했으면
                    continue
                if not arr[nr][nc]: # 집이 아니면
                    continue
                queue.append([nr, nc])
                visited[nr][nc] = 1
                result += 1
    return result




N = int(input())
arr = [list(map(int, input())) for _ in range(N)]
visited = [[0] * N for _ in range(N)]
ans = []

# 입력 끝! 로직 시작!

for r in range(N):
    for c in range(N):
        if arr[r][c] and not visited[r][c]:
            ans.append(bfs(r, c))

ans.sort()
print(len(ans))
print(*ans, sep="\n")
