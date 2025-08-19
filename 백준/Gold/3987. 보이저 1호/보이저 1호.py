N, M = map(int, input().split())
arr = [list(input()) for _ in range(N)]

# 전처리
dic = {'\\': [3, 2, 1, 0], '/': [1, 0, 3, 2], '.': [0, 1, 2, 3]}
td = {0: 'U', 1: 'R', 2: 'D', 3: 'L'}
debug = 0

sr, sc = map(lambda x: int(x) - 1, input().split())

ans, ansd = 0, '-'  # 최댓값 찾기

# 상우하좌
dr = [-1, 0, 1, 0]
dc = [0, 1, 0, -1]

for sd in range(4):  # 처음 방향 0, 1, 2, 3
    visited = [[[0] * 4 for i in range(M)] for _ in range(N)]
    cr, cc, cd = sr, sc, sd

    movec = 0

    while 0 <= cr < N and 0 <= cc < M and arr[cr][cc] != 'C':
        if visited[cr][cc][cd]:  # 같은 장소 같은 방향으로 이미 방문했으면
            ans = 'Voyager'
            break

        visited[cr][cc][cd] = 1  # 방문처리
        movec += 1  # 시간 + 1
        cd = dic.get(arr[cr][cc])[cd]  # 방향 바꾸기

        cr, cc = cr + dr[cd], cc + dc[cd]

        debug = 1

    if ans == 'Voyager':
        ansd = td.get(sd)
        break
    elif ans < movec:
        ansd = td.get(sd)
        ans = movec

print(ansd)
print(ans)