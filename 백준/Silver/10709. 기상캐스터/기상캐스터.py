# 조건
# 지금부터 몇 분후에 처음으로 구역 (i, j) 에 구름이 뜨는지를 표시
# 처음부터 구역 (i, j) 에 구름이 떠 있었던 경우에는 0
# 몇 분이 지나도 구름이 뜨지 않을 경우에는 -1

N, M = map(int, input().split())
arr = [list(input()) for _ in range(N)]

ans = [[-1] * M for _ in range(N)]

# 행 반복문
for i in range(N):
    # 열 반복문
    cnt = -1
    for j in range(M):
        # 구름이면 cnt를 0으로
        if arr[i][j] == 'c':
            cnt = 0
        # 전에 구름이 있었으면
        if cnt != -1:
            ans[i][j] = cnt
            cnt += 1

for i in range(N):
    print(*ans[i])
