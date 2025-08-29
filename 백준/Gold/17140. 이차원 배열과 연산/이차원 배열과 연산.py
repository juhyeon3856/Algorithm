'''체크리스트
배열의 인덱스는 1부터 시작한다

'''

r, c, k = map(int, input().split())
r, c = r - 1, c - 1
arr = [[0] * 100 for _ in range(100)]

R, C = 3, 3

for i in range(3):
    arr[i][0], arr[i][1], arr[i][2] = map(int, input().split())

debug = 0  # 입력 arr 확인


# 로직
def calc(row):
    mi = 0
    for cr in range(row):
        arr[cr], llen = sort_func(arr[cr])
        mi = llen if llen > mi else mi
    return mi


def sort_func(flst):
    # lookup table
    cnt = [0] * 101
    for i in range(100):
        cnt[flst[i]] += 1

    # 튜플 리스트 만들기
    cnt_lst = []
    for n in range(1, 101):
        if cnt[n]:
            cnt_lst.append((cnt[n], n))

    # 정렬하기
    cnt_lst.sort()

    # 다시 리스트 만들기
    result_lst = [0] * 100
    size = 0
    for i in range(0, len(cnt_lst)):
        if i >= 100:
            break
        cnt, num = cnt_lst[i]
        result_lst[i * 2] = num
        result_lst[i * 2 + 1] = cnt
        size = i * 2 + 2
    return result_lst, size  # 10000인 경우 없어야함


ans = 0
while True:
    if arr[r][c] == k:
        break
    if ans > 100:
        ans = -1
        break

    if R >= C:
        # _R = R
        C = calc(R)
    else:
        arr = [list(lst) for lst in zip(*arr)]
        R = calc(C)
        arr = [list(lst) for lst in zip(*arr)]
    ans += 1

print(ans)
