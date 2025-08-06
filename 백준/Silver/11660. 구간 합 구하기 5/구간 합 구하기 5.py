# 시작시간 : 7시 47분


N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
ssum = [[0] * (N + 1) for _ in range(N + 1)]

# 누적합 구하기
for r in range(N):
    sum_line = 0
    for c in range(N):
        sum_line += arr[r][c]
        ssum[r + 1][c + 1] = sum_line + ssum[r][c + 1]


# 합구하기 및 정답
ans = []
for _ in range(M):
    r1, c1, r2, c2 = map(int, input().split())
    ans.append(ssum[r2][c2] - ssum[r1 - 1][c2] - ssum[r2][c1 - 1] + ssum[r1 - 1][c1 - 1])

print(*ans, sep="\n")