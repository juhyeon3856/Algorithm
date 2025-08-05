#  1부터 N까지의 수로 이루어진 순열을 사전순으로 출력하

N = int(input())


def perm(depth):
    if depth == N:
        print(*nums)
        return
    for i in range(1, N + 1):
        if visited[i]:  # 이미 사용했으면
            continue
        visited[i] = 1
        nums[depth] = i
        perm(depth + 1)
        visited[i] = 0


nums = [0] * N
visited = [0] * (N + 1)
perm(0)