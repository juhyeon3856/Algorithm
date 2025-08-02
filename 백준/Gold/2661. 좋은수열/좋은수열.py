# 시작시간 3시 8분

# 1, 2, 3순서대로 백트래킹(+dfs)


def dfs(depth):
    if depth == N:
        return True
    for n in (1, 2, 3):
        nums[depth] = n
        if not check(depth + 1): continue  # 좋은 수열이 아니면
        if dfs(depth + 1):  # 좋은 수열이면 다음 수 선택
            return True  # 길이가 N인 좋은 수열이 완성 됬으면 더 이상 진행 X
    return False


# 좋은 수열인지 확인
def check(nlen):
    cnt = 1  # 동일한 부분 길이
    while nlen >= 2 * cnt:
        if nums[nlen - 2 * cnt:nlen - cnt] == nums[nlen - cnt:nlen]:  # 뒤에서 동일한 부분이 나오면
            return False  # 좋은 수열이 아니다.
        cnt += 1
    return True  # 좋은 수열이다.


# 입력
N = int(input())
nums = [0] * N

dfs(0)
print(*nums, sep="")