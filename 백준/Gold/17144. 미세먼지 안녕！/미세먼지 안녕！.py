# 3? 47 50 60

# 입력
N, M, T = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

# 변수, 함수 선언

# 공기청정기 위, 아래
up_lst = []
down_lst = []


def check(fr, fc):
    return 0 <= fr < N and 0 <= fc < M


def move_dust():
    '''
    먼지 확산시키기
    - 인접 네방향
        - 범위 밖 pass
        - 공기청정기 pass
        - 확산은 arr[r][c] // 5
        - 확산할때마다 중앙에서 그만큼 빠지는거

    :return: 확산된 arr리턴
    '''
    new_arr = [[0] * M for _ in range(N)]
    for r in range(N):
        for c in range(M):
            if arr[r][c] > 0:  # 먼지 있으면
                delta = arr[r][c] // 5
                new_arr[r][c] += arr[r][c]
                for d in range(4):
                    nr, nc = r + dr[d], c + dc[d]
                    if not check(nr, nc):
                        continue
                    if arr[nr][nc] == -1:
                        continue
                    new_arr[nr][nc] += delta
                    new_arr[r][c] -= delta
            elif arr[r][c] == -1:
                new_arr[r][c] = -1
    return new_arr


def clean(flst):
    '''
    flst에 있는 인덱스를 앞 칸으로 한칸씩 이동시킨다. 
    :param flst: 인덱스 리스트
    :return:
    '''
    llen = len(flst)
    for i in range(llen - 1, 0, -1):
        arr[flst[i][0]][flst[i][1]] = arr[flst[i - 1][0]][flst[i - 1][1]]
    arr[flst[0][0]][flst[0][1]] = 0


def make_lst(flst, fr, fc):
    '''
    공기청정기가 돌아가는 방향대로 인덱스 리스트에 붙이기
    :param flst: 붙일 리스트
    :return: 없음
    '''
    for d in range(4):
        while check(fr + dr[d], fc + dc[d]):
            fr, fc = fr + dr[d], fc + dc[d]
            if arr[fr][fc] == -1:
                break
            flst.append((fr, fc))


for r in range(N):
    for c in range(M):
        if arr[r][c] == -1:
            if not up_lst:  # 처음 만난 -1이면(위로 회전)
                dr, dc = [0, -1, 0, 1], [1, 0, -1, 0]
                make_lst(up_lst, r, c)
            else:  # 아래 공기청정기
                dr, dc = [0, 1, 0, -1], [1, 0, -1, 0]
                make_lst(down_lst, r, c)

debug = 0  # uplst, downlst
# 로직
for _ in range(T):
    # 먼지 확산
    arr = move_dust()

    debug = 1  # 먼지 확산 확인
    # 공기청정기 작동
    clean(up_lst)  # 위 작동
    debug = 2  # 공기청정기 확인
    clean(down_lst)  # 아래 작동
    debug = 3  # 공기청정기 확인

ans = 2  # 공기청정기 2개 빼기
for r in range(N):
    for c in range(M):
        ans += arr[r][c]

print(ans)