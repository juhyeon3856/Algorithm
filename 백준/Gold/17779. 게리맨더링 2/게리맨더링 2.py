# 구역나누기 test

N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]


def make_group(x0, y0, d1, d2):
    group_sum = [0] * 5  # 5그룹
    # test_arr = [[5] * N for _ in range(N)]

    # 끝 좌표
    x1, y1 = x0 + d1, y0 - d1
    x2, y2 = x0 + d2, y0 + d2
    x3, y3 = x0 + d1 + d2, y0 - d1 + d2

    # 구역별로 더하기
    for r in range(N):
        for c in range(N):
            if r < x1 and c <= y0 and r + c < x0 + y0:
                group_sum[0] += arr[r][c]
                # test_arr[r][c] = 1
            elif r <= x2 and c > y0 and r - c < x0 - y0:
                group_sum[1] += arr[r][c]
                # test_arr[r][c] = 2
            elif r >= x1 and c < y3 and r - c > x1 - y1:
                group_sum[2] += arr[r][c]
                # test_arr[r][c] = 3
            elif r > x2 and c >= y3 and r + c > x2 + y2:
                group_sum[3] += arr[r][c]
                # test_arr[r][c] = 4
            else:
                group_sum[4] += arr[r][c]
    if min(group_sum) == 0:
        return -1
    return max(group_sum) - min(group_sum)


def print_arr(farr):
    for flst in farr:
        print(*flst)


def check(fr, fc):
    return 0 <= fr < N and 0 <= fc < N


def check_set():  # 시간 줄이기 가능
    x, y, d1, d2 = nums
    if d1 == 0 or d2 == 0:
        return False
    # if not (check(x, y)):
    #     return False
    if y - d1 < 0:
        return False
    if y + d2 >= N:
        return False
    if x + d1 + d2 >= N:
        return False
    return True


def perm(depth):
    if depth == 4:
        cnt[1] += 1
        if check_set():  # 4 조합이 가능한 범위이면
            _ans = make_group(nums[0], nums[1], nums[2], nums[3])
            # print(*nums)
            if _ans < 0:  # 정답이 될 수 없음
                print("!!!!!!!!!!!!!!!")
                return
            cnt[0] += 1
            ans[0] = _ans if _ans < ans[0] else ans[0]
        return

    for i in range(N):
        nums[depth] = i
        perm(depth + 1)


cnt = [0, 0]
nums = [0] * 4
ans = [float('inf')]

perm(0)

print(ans[0])
# print(cnt)
