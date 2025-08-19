# 이동 중 벽이나 방문한 지역, 장애물을 만날 경우 -> 다음 명령 -> 해당 내용 놓침(디버깅)
# 명령은 무한루프
# 로봇이 움직일 수 없을 경우 동작을 멈춘

# 입력
R, C = map(int, input().split())  # 방 크기
k = int(input())  # 장애물 개수
block = [list(map(int, input().split())) for _ in range(k)]
cr, cc = map(int, input().split())
cmds = list(map(lambda x: int(x) - 1, input().split()))  # 상하좌우

# 전처리
dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

visited = [[0] * C for _ in range(R)]
cmdi, cmdc = 0, len(cmds)  # 명령 인덱스, 명령 총 개수
cmd_visited = [-1] * cmdc
movec = 0

# visited에 장애물 있는 위치 2로 만들어두기 -> 갈 수 없음
for br, bc in block:
    visited[br][bc] = 2

# 시작위치 방문처리
visited[cr][cc] = 1


# 로직
def stop(fr, fc):
    if not (0 <= fr < R and 0 <= fc < C):  # 범위 밖
        return False  # 멈춰
    if visited[fr][fc]:  # 이미 방문했으면
        return False  # 멈춰
    return True


while cmd_visited[cmdi] != movec:  # 더이상 이동이 없을 시 break
    cmd_visited[cmdi] = movec  # 다음번에도 movec번째에 또 오면 마지막 위치

    # 명령 받음
    while stop(cr + dr[cmds[cmdi]], cc + dc[cmds[cmdi]]):
        cr, cc = cr + dr[cmds[cmdi]], cc + dc[cmds[cmdi]]
        visited[cr][cc] = 1
        movec += 1

    cmdi = (cmdi + 1) % cmdc  # 다음명령

# 정답 출력
print(cr, cc)