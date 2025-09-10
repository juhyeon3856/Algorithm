# 입력
N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

# 전처리

move_index = []
cr, cc = ((N + 1) // 2) - 1, ((N + 1) // 2) - 1

dr = [0, 1, 0, -1]
dc = [-1, 0, 1, 0]
ds = ['←', '↓', '→', '↑']
size, d = 1, 0
for _ in range(N):
    for _ in range(2):
        for _ in range(size):
            cr, cc = cr + dr[d], cc + dc[d]
            move_index.append((cr, cc))
        d = (d + 1) % 4
    size += 1

move_index = move_index[:N * N - 1] + [(((N + 1) // 2) - 1, ((N + 1) // 2) - 1)]  # 마지막 상어위치

# # move_index test
# test = [[0] * N for _ in range(N)]
# i = 1
# for r, c in move_index:
#     test[r][c] = i
#     i += 1
# debug = 0


dr = [100, -1, 1, 0, 0]
dc = [100, 0, 0, -1, 1]
ds = ['-', '↑', '↓', '←', '→']
sr, sc = ((N + 1) // 2) - 1, ((N + 1) // 2) - 1

cnt_ans = [0, 0, 0, 0]  # i번 구슬 폭발한 개수


# 함수들
def sort_block():
    delta = 1
    for i in range(1, len(move_index) - 1):
        pr, pc = move_index[i - delta]
        cr, cc = move_index[i]

        if arr[pr][pc] == 0 and arr[cr][cc] == 0:
            delta += 1
            continue

        if arr[pr][pc] == 0:  # 0이면
            arr[pr][pc] = arr[cr][cc]
            arr[cr][cc] = 0


# 상어랑 가까운 순으로 구슬번호, 구슬 개수 리턴
# 단 4개 이상인 것들은 제외 -> 폭발
def make_stack():
    num_stack = []  # 구슬 번호
    cnt_stack = []  # 개수
    is_remove = 0

    for r, c in move_index:  # 마지막 상어인덱스니까 무조건 다름
        cur_num = arr[r][c]
        # if num_stack:  # 스택에 있으면
        if num_stack and num_stack[-1] == cur_num:  # 젤 위가 현재랑 같으면
            cnt_stack[-1] += 1
            continue

        if num_stack and num_stack[-1] != cur_num and cnt_stack[-1] > 3:  # 다른데 4이상이면(제거 필요)
            is_remove = 1
            delete_cnt = cnt_stack.pop()  # 그거 빼기
            delete_num = num_stack.pop()
            cnt_ans[delete_num] += delete_cnt  # 폭발 정답 처리
            debug = 1  # 정답 처리 확인

        # 스택이 비어있으면, 젤 위랑 다르면 등 등 나머지 모든 경우
        # 스택에 추가
        num_stack.append(cur_num)
        cnt_stack.append(1)

        # 0나오면 더이상 안봄
        if cur_num == 0:
            break

    cnt_stack[-1] = N * N * 10  # 마지막 항상 0이니까! 0 많이 넣어주기
    return num_stack, cnt_stack, is_remove


# stack을 이용하여 한번에 터트리기
def remove_block():
    num_stack, cnt_stack, is_remove = make_stack()
    idx = 0
    for r, c in move_index:
        arr[r][c] = num_stack[idx]
        cnt_stack[idx] -= 1

        if cnt_stack[idx] == 0:
            idx += 1
    return is_remove


def copy_block():
    num_stack, cnt_stack, _ = make_stack()  # 3 이상인 블럭 없음 -> 4 이상 지워지는 로직 의미 없음

    insert_value = []
    for num, cnt in zip(num_stack, cnt_stack):
        insert_value.append(cnt)
        insert_value.append(num)

    insert_value = insert_value[:-2] + ([0] * (N * N))  # 나머지 0으로

    for (r, c), iv in zip(move_index, insert_value):  # 순서대로 값 넣기
        arr[r][c] = iv


for _ in range(M):
    di, si = map(int, input().split())
    # [1] 블리자드 마법 시전
    # (N+1)/2-1, (N+1)/2-1 기준 d방향으로 s칸
    # 복잡도 s
    for s in range(1, si + 1):
        nr, nc = sr + dr[di] * s, sc + dc[di] * s
        arr[nr][nc] = 0  # si <= (N-1)/2 이므로 범위 넘어가지 않음

    # [2] 구슬 당기기
    # 복잡도 N*N
    sort_block()

    # [3] 구슬 폭발하기
    # 4개 이상 연속하는 구슬 폭발
    # 1, 2, 3각각 터진 개수 저장해두기
    # 더 이상 폭발이 일어나지 않을 때 까지 [2][3] 반복
    # 복잡도 N*N * 반복횟수(N*N/4) -> 반복횟수 항상 이런거 아니니까 일단 안전하게 가자
    while remove_block() == 1:
        pass

    # [4] 구슬 복사하기
    # 그룹 구슬의 개수, 그룹 구슬의 번호
    # 복잡도 N*N
    copy_block()
    arr[sr][sc] = 0

# 정답처리
ans = 0
for i in range(1, 4):
    ans += cnt_ans[i] * i
print(ans)
