from collections import deque

# 입력
N, M = map(int, input().split())  # 세로, 가로
arr = [list(map(int, input().split())) for _ in range(N)]  # 불2, 벽1, 빈칸0

# 전처리

# [1] 불 있는곳 찾아두기, 벽 개수 세기
fire = []
bb = 0  # 벽 개수
ff = 0  # 초기 불 개수
for r in range(N):
    for c in range(M):
        if arr[r][c] == 2:
            fire.append((r, c))
            ff += 1
        elif arr[r][c] == 1:
            bb += 1

# [2] visited는 로직 안에서 계속 생성

# [3] 정답 관련 (정답 : N*M - mn - bb
mn = N * M  # 불 퍼지는 것 최솟값 저장해두기

# [4] 불 이동
dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

# 로직

# [1] N*M개 빈칸 중 3개 뽑는 로직
R = N * M


def combi(depth, start):
    global mn
    if depth == 3:  # 3개 뽑았으면
        rs = update()  # 번지는 개수(최소보다 크면 -1리턴)
        if rs >= 0:
            mn = rs
        return

    for i in range(start, R):
        nr, nc = i // M, i % M
        if arr[nr][nc]:  # 불이나 벽이 있으면
            continue
        else:  # 빈칸이면
            arr[nr][nc] = 3  # 벽 새로 만들기
            combi(depth + 1, i + 1)
            arr[nr][nc] = 0  # 벽 없애주기


# [2] 불 번지게 하는 로직
def update():
    queue = deque(fire)  # 불 초기 설정
    visited = [[0] * M for _ in range(N)]
    result = 0

    while queue:
        cr, cc = queue.popleft()
        for d in range(4):
            nr, nc = cr + dr[d], cc + dc[d]

            if not (0 <= nr < N and 0 <= nc < M):
                continue

            if arr[nr][nc]:  # 불이나 벽이 있으면
                continue

            if visited[nr][nc]:
                continue

            queue.append((nr, nc))
            visited[nr][nc] = 1
            result += 1

        if result >= mn:
            return -1

    if result < mn:  # 아마 없어도 동일한 로직일것으로 보여짐
        return result
    else:
        print("!!!!!!!!!!!!!!!!!!!!!")  # 이런 일 없어야함
        return -1


# [3] 실행
combi(0, 0)

# 정답 출력
print(R - bb - ff - 3 - mn)