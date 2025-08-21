# 가능한 모든 경우의 수 구하기 3^15에서 푸르닝 많이 됨

# (a, b)
cases = []
for i in range(6):
    for j in range(i + 1, 6):
        if i == j:
            continue
        cases.append((i, j))

debug = 0  # 가능한 모든 케이스 15가지 확인하긴


def perm(depth, tc):
    if ans[tc]:  # 답 나왔으면 더 안함
        return
    if depth == 15:
        ans[tc] = 1
        return

    a, b = cases[depth]
    # a승
    if arr[a][0] and arr[b][2]:
        arr[a][0] -= 1
        arr[b][2] -= 1
        perm(depth + 1, tc)
        arr[a][0] += 1
        arr[b][2] += 1

    # a무
    if arr[a][1] and arr[b][1]:
        arr[a][1] -= 1
        arr[b][1] -= 1
        perm(depth + 1, tc)
        arr[a][1] += 1
        arr[b][1] += 1

    # a패
    if arr[a][2] and arr[b][0]:
        arr[a][2] -= 1
        arr[b][0] -= 1
        perm(depth + 1, tc)
        arr[a][2] += 1
        arr[b][0] += 1


# 입력
ans = [0, 0, 0, 0]
for t in range(4):
    lst = list(map(int, input().split()))
    arr = []

    for i in range(6):
        arr.append([lst[i * 3], lst[i * 3 + 1], lst[i * 3 + 2]])
        if lst[i * 3] + lst[i * 3 + 1] + lst[i * 3 + 2] != 5:
            break
    else:
        perm(0, t)

# 정답
print(*ans)
