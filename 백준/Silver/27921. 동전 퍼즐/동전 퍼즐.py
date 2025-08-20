N, M = map(int, input().split())  # 최대 10
arr = [list(input()) for _ in range(N)]

N1, M1 = map(int, input().split())  # 최대 10
arr1 = [list(input()) for _ in range(N1)]

# [1] arr1에서 0이 있는 위치 뽑기
coins = []
for r1 in range(N1):
    for c1 in range(M1):
        if arr1[r1][c1] == 'O':
            coins.append((r1, c1))


# [2] 코인에 r, c만큼 더해가면서(평행이동) arr에 동전과 같은 개수 세기(mn에 max값 저장)
def check(fr, fc):
    return 0 <= fr < N and 0 <= fc < M


mn = 0  # 안옮겨도 되는 동전 최대
for r in range(-11, 11):
    for c in range(-11, 11):
        samec = 0
        for cr, cc in coins:
            nr, nc = r + cr, c + cc
            if not check(nr, nc):
                continue
            if arr[nr][nc] == 'O':
                samec += 1
        mn = max(mn, samec)

# [3] 정답 출력 : 정답 = 코인 수 - mn
print(len(coins) - mn)