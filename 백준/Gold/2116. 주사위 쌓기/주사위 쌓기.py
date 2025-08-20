# 입력
N, M = int(input()), 6
arr = [list(map(int, input().split())) for _ in range(N)]

# 전처리
# [1] 배열 바닥 인덱스로 윗면 접근 가능하도록 수정
nxts = []
for a, b, c, d, e, f in arr:
    result = [0] * (M + 1)
    result[a] = f  # 바닥이 a이면 위는 f이다.
    result[b] = d
    result[c] = e
    result[d] = b
    result[e] = c
    result[f] = a
    nxts.append(result)

# [2] 1, 2, 3, 4, 5, 6으로 주사위 바닥을 시작했을 때 모양을 만들기(벽면 최댓값만 기록)
# debug = []
ans = []
for s in range(1, M + 1):
    sn = s
    ans.append(0)
    # db = []
    for nxt in nxts:
        nn = nxt[sn]
        if (sn, nn) == (5, 6) or (sn, nn) == (6, 5):
            ans[-1] += 4  # 벽면 최댓값 4
            # db.append((sn, nn, 4))
        elif sn == 6 or nn == 6:  # 5는 아닌데 둘중 하나 6이면
            ans[-1] += 5  # 벽면 최대 5
            # db.append((sn, nn, 5))
        else:
            ans[-1] += 6
            # db.append((sn, nn, 6))
        sn = nn
    # debug.append(db)

# [3] 정답 출력 -> ans의 최댓값
print(max(ans))