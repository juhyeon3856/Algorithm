# 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열

N, M = map(int, input().split())


def perm(depth):
    if depth == M:
        print(*nums)
        return
    for i in range(1, N + 1):
        if visited[i]: continue  # 한번 사용한 값은
        nums[depth] = i
        visited[i] = 1    # 사용했음
        perm(depth + 1)    
        visited[i] = 0    # 나왔으니까 사용 안함으로 되돌리기 


nums = [0] * M
visited = [0] * (N + 1)
perm(0)
