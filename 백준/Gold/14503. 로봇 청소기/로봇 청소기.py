# 입력
N, M = map(int, input().split())  # 세로, 가로
cr, cc, cd = map(int, input().split())
# d는 0부터 3까지 [북, 동, 남, 서], 0인덱스
arr = [list(map(int, input().split())) for _ in range(N)]
# 0은 도로, 1은 인도

# 전처리
dr = [-1, 0, 1, 0]  # 북동남서
dc = [0, 1, 0, -1]

ans = 1  # 지나온 칸 수

visited = [[0] * M for _ in range(N)]
visited[cr][cc] = 1

# 로직

# [1] 이동

while True:
    for _ in range(4):  # (1) 4방향 탐색
        nd = (cd - 1) % 4  # 현 방향 기준 왼쪽
        nr, nc = cr + dr[nd], cc + dc[nd]
        if arr[nr][nc] or visited[nr][nc]:  # 인도거나 방문했으면
            cd = (cd - 1) % 4  # 왼쪽으로 돌리기
        else:  # 갈 수 있으면
            cr, cc, cd = nr, nc, nd  # 이동했으면
            visited[cr][cc] = 1
            ans += 1
            break
    else:  # (2) 네 방향 모두 이동 못했으면
        nr, nc = cr + dr[cd] * -1, cc + dc[cd] * -1  # 한칸 후진
        if arr[nr][nc]:  # 인도이면
            break
        else:
            cr, cc = nr, nc
            if not visited[cr][cc]:  # 아직 방문 안헀으면
                visited[cr][cc] = 1
                ans += 1

    debug = 0

# [2]정답 출력
print(ans)