# N은 50
# 총 2500

# [sol]
# 1. 행, 열 먹을 수 있는 최댓값 구하기
# 2. 가로, 세로로 순회하면서 양 옆 바꾸고 그 열(행) 다시 세기(A) -> 최댓값 업데이트

# [A 먹을 수 있는 최댓값]
# 행 세기


# [A 먹을 수 있는 최댓값]
def cnt(lst):
    result = 0
    cur = '-'
    cnt = 1
    for l in lst + ["!"]:
        if cur == l:
            cnt += 1
        else:
            result = max(result, cnt)
            cur = l
            cnt = 1
    return result


def sol():
    result = 0
    # 바꾸기 전
    for r in range(N):
        result = max(cnt(arr[r]), result)

    # 하나씩 바꾸면서
    for c in range(N):
        for r in range(1, N):
            if arr[r][c] == arr[r-1][c]: continue
            arr[r - 1][c], arr[r][c] = arr[r][c], arr[r - 1][c]
            result = max(result, cnt(arr[r]))
            result = max(result, cnt(arr[r - 1]))
            result = max(result, cnt([list(row) for row in zip(*arr)][c]))
            arr[r - 1][c], arr[r][c] = arr[r][c], arr[r - 1][c]
    return result


N = int(input())
arr = [list(input()) for _ in range(N)]
ans = sol()
arr = [list(row) for row in zip(*arr)]
print(max(ans, sol()))
