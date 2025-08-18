# 입력 및 전처리
idx = [(0, 4), (1, 1), (3, 5), (1, 3), (3, 3), (2, 6), (3, 7), (1, 7), (4, 4), (2, 2), (3, 1), (1, 5)]

sum_idx = [(0, 3, 9, 10), (10, 4, 2, 6), (0, 11, 5, 6), (1, 3, 11, 7), (1, 9, 4, 8), (8, 2, 5, 7)]

temp_dic = 'xABCDEFGHIJKL'
dic = {temp_dic[i]: i for i in range(13)}
rdic = {i: temp_dic[i] for i in range(13)}

arr = [list(input()) for _ in range(5)]
nums = []
visited = [0] * 13

for r, c in idx:
    nxt = arr[r][c]
    nums.append(dic.get(nxt))
    visited[dic.get(nxt)] = 1

debug = 0  # nums, visited확인

ans = []


# 순열
def perm(depth):
    if ans:  # 정답이 있으면
        return

    if depth == 12:
        if is_ans():
            ans.extend(nums)
        return

    if nums[depth]:
        perm(depth + 1)  # 이미 선택되어있으면
        return

    for i in range(1, 13):
        if visited[i]:
            continue

        visited[i] = 1
        nums[depth] = i
        perm(depth + 1)
        nums[depth] = 0
        visited[i] = 0


def is_ans():
    ssum = []
    for i1, i2, i3, i4 in sum_idx:
        if nums[i1] + nums[i2] + nums[i3] + nums[i4] != 26:
            return False
    return True


perm(0)

# 정답 출력 만들기
for i in range(12):
    r, c = idx[i]
    arr[r][c] = rdic.get(ans[i])

# 정답 출력
for lst in arr:
    print(*lst, sep="")