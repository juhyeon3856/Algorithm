# 풀이 시간 : 19:10 ~ 19:44
# 디버깅 : 19:44 ~ 19:59
# 소요시간 : 34 + 15 = 49분
# 아이디어 : 순회하며 5개인지 확인
#           시작점에서만 4방으로 확인
#           6번째 돌과는 색상이 달라야함

N = 19
arr = [list(map(int, input().split())) for _ in range(N)]

# 4방향 : 우상, 우, 우하, 하
dr = [-1, 0, 1, 1]
dc = [1, 1, 1, 0]


def isStart(fr, fc, fd):
    nr, nc = fr + dr[fd] * -1, fc + dc[fd] * -1
    # check역방이 시작점인지
    if 0 <= nr < N and 0 <= nc < N:  # 범위 안이면
        if arr[nr][nc] != arr[fr][fc]:  # 색이 다르거나
            return True
    else:  # 범위 밖이거나
        return True
    return False  # 주석 이외 경우 시작점 아님


def check(fr, fc):
    for d in range(4):
        if not isStart(fr, fc, d):  # 시작하는 좌표가 아니면
            continue  # 5개 만드는지 확인하지 않음(불가)
        # 5개 만드는지 확인
        for i in range(1, 5):
            nr, nc = fr + dr[d] * i, fc + dc[d] * i
            if 0 <= nr < N and 0 <= nc < N:
                if arr[fr][fc] != arr[nr][nc]:  # 색이 달라서
                    break
            else:
                break  # 돌이 더 없어서 해당 방향(d)으로는 연속 5개 만들지 못함
        else:   # 5개는 같은 색이다~
            nr, nc = fr + dr[d] * 5, fc + dc[d] * 5
            if 0 <= nr < N and 0 <= nc < N:  # 5번째는 색이 다르면
                if arr[fr][fc] != arr[nr][nc]:
                    return [arr[fr][fc], fr, fc]
            else:
                return [arr[fr][fc], fr, fc]
    return [0, -1, -1]  # 4가지 방향 모두 5개 연속을 만들지 못함


def sol():
    for r in range(N):
        for c in range(N):
            if arr[r][c] == 0:  # 돌이 없으면
                continue
            result = check(r, c)  # 4방향에 대하여 5개를 만드는지
            if result[0]:  # 5개 만드는 것이 있으면
                return result
    return [0]


ans = sol()

if ans[0]:
    print(ans[0])
    print(ans[1] + 1, ans[2] + 1)  # 가로줄, 세로줄
else:
    print(0)
