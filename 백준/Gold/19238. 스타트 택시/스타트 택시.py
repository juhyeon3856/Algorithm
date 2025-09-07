from collections import deque

# 입력
N, M, K = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

tr, tc = map(lambda x: int(x) - 1, input().split())

custs = [[0]] + [list(map(lambda x: int(x) - 1, input().split())) for _ in range(M)]

# 전처리
cnt_cust = M  # 남은 승객 수
ck = K  # 남은 연료

# [1] customers
cust_arr = [[0] * N for _ in range(N)]
for i in range(1, M + 1):
    cust_arr[custs[i][0]][custs[i][1]] = i  # i번째 손님 위치 만들어주기
    # cust_arr[custs[i][2]][custs[i][3]] = -i  # i번째 도착지 만들어주기

# [2] dr, dc
dr = [-1, 1, 0, 0]
dc = [0, 0, 1, -1]


# 함수들
def check(fr, fc):
    return 0 <= fr < N and 0 <= fc < N


# sr, sc에서 출발해서 가장 가까운 손님 위치 찾기
# 없으면 거리 -1
def find_cust(sr, sc):
    visited = [[0] * N for _ in range(N)]
    queue = deque()

    # 초기값
    queue.append((sr, sc))
    visited[sr][sc] = 1

    while queue:
        size = len(queue)
        result = []
        for _ in range(size):
            cr, cc = queue.popleft()

            # 정답처리
            if cust_arr[cr][cc]:
                result.append((cr, cc))
                # return (cr, cc), visited[cr][cc] - 1  # 현 인덱스, 이동거리

            for d in range(4):
                nr, nc = cr + dr[d], cc + dc[d]

                if not check(nr, nc):  # 범위체크
                    continue

                if arr[nr][nc]:  # 벽이면
                    continue

                if visited[nr][nc]:  # 방문처리
                    continue

                queue.append((nr, nc))
                visited[nr][nc] = visited[cr][cc] + 1

        if result:  # 손님 있으면 번호 작은 손님 찾아서 리턴
            rr, rc = min(result)
            # rr, rc = custs[cus_idx][0], custs[cus_idx][1]
            return (rr, rc), visited[rr][rc] - 1

    return (100, 100), -1


# sr, sc에서 er, ec까지 가는 이동거리 출력
# 안되면 거리 -1
def move_goal(sr, sc, er, ec):
    visited = [[0] * N for _ in range(N)]
    queue = deque()

    # 초기값
    queue.append((sr, sc))
    visited[sr][sc] = 1

    while queue:
        cr, cc = queue.popleft()

        # 정답처리
        if (cr, cc) == (er, ec):
            return visited[cr][cc] - 1  # 현 인덱스, 이동거리

        for d in range(4):
            nr, nc = cr + dr[d], cc + dc[d]

            if not check(nr, nc):  # 범위체크
                continue

            if arr[nr][nc]:  # 벽이면
                continue

            if visited[nr][nc]:  # 방문처리
                continue

            queue.append((nr, nc))
            visited[nr][nc] = visited[cr][cc] + 1

    return -1


# 로직
while cnt_cust and ck > 0:  # 손님과 연료가 다 있을때
    # 손님 찾기
    cust_index, move_dist = find_cust(tr, tc)

    if move_dist == -1:  # 갈 수 있는 승객이 없으면
        break

    if ck < move_dist:  # 연료가 부족하면
        break

    ck -= move_dist  # 연료 빼기
    tr, tc = cust_index  # 손님쪽으로 이동

    cust_id = cust_arr[tr][tc]

    # 목적지 이동
    move_dist = move_goal(tr, tc, custs[cust_id][2], custs[cust_id][3])

    if move_dist == -1:  # 목적지에 갈 수 없으면
        break

    if ck < move_dist:  # 연료가 부족하면
        break

    ck += move_dist  # 연료 충전
    tr, tc = custs[cust_id][2], custs[cust_id][3]  # 도착지로 이동

    cnt_cust -= 1  # 1명 이동 완료!
    cust_arr[custs[cust_id][0]][custs[cust_id][1]] = 0  # 손님 지워주기

# 정답처리
if cnt_cust == 0:  # and ck >= 0:  # 손님 다 이동 시키고 연료 남았으면
    print(ck)
else:  # 연료가 바닥나거나 모든 손님 이동시키지 못했음
    print(-1)