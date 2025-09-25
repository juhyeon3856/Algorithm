# 11시 49분 시작
# 11시 51분 코드 작성
# 12시 1분 코드작성 완료 디버깅 시작
'''
20
좋아하는 친구 많은 순
빈칸 많은 순
행 작은순
열 작은순

점수는
좋아하는 친구의 수 -> 다시 계산해야함
'''

N = int(input())
list_dict = {}
order_lst = []
for _ in range(N * N):
    ni, l1, l2, l3, l4 = map(int, input().split())
    list_dict[ni] = {l1, l2, l3, l4}
    order_lst.append(ni)

dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]


def check(r, c):
    return 0 <= r < N and 0 <= c < N


def find_index(num):
    candi = []
    for r in range(N):
        for c in range(N):
            if arr[r][c] != 0:
                continue
            score, blank = get_score_blank(r, c, num)
            candi.append((-score, -blank, r, c))
    return min(candi)


def get_score_blank(r, c, num):
    score, blank = 0, 0
    for d in range(4):
        nr, nc = r + dr[d], c + dc[d]
        if not check(nr, nc):
            continue
        if arr[nr][nc] == 0:
            blank += 1
            continue
        if arr[nr][nc] in list_dict[num]:
            score += 1
    return score, blank  # score, blank


def get_score(score):
    if score == 0:
        return 0
    if score == 1:
        return 1
    if score == 2:
        return 10
    if score == 3:
        return 100
    if score == 4:
        return 1000


arr = [[0] * N for _ in range(N)]
for sn in order_lst:
    _, _, sr, sc = find_index(sn)
    arr[sr][sc] = sn

ans = 0

for gr in range(N):
    for gc in range(N):
        _score, _ = get_score_blank(gr, gc, arr[gr][gc])
        ans += get_score(_score)
print(ans)
