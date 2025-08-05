# 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
# 고른 수열은 오름차순이어야 한다.
# 중복되는 수열을 여러 번 출력하면 안되며

N, M = map(int, input().split())


def combi(depth, start):
    if depth == M:
        print(*nums)
        return
    for i in range(start, N + 1):
        nums[depth] = i
        combi(depth + 1, i + 1)


nums = [0] * M
combi(0, 1)