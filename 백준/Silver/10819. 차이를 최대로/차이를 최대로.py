N = int(input())
lst = list(map(int, input().split()))


def perm(depth, flag):
    if depth == N:
        ans[0] = max(ans[0], calc())
        return
    for i in range(N):
        if flag & 1 << i: continue
        nums[depth] = lst[i]
        perm(depth + 1, flag | 1 << i)


def calc():
    result = 0
    for i in range(1, N):
        result += abs(nums[i] - nums[i - 1])
    return result


ans = [0]
nums = [0] * N
perm(0, 0)
print(ans[0])