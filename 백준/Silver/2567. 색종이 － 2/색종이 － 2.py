# 시작시간 7시 38분
# 끝난시간 7시 
# 총 소요시간 

# 시도횟수 2회


# 조건
# 색종이 붙인 후 색종이 영역 둘레

# 아이디어
# 색종이 붙은 곳 1로 만들고
# 다 붙인 후 세로로 보면서 0 <-> 1로 변하는 구간 수 세기
# 가로도 마찬가지

# 시간복잡도
# 100 * 100 + 10 * 10 * N

N = int(input())
arr = [[0] * 102] + [[0] * 102 for _ in range(100)] + [[0] * 102]

# 입력
for _ in range(N):
    sr, sc = map(int, input().split())

    for r in range(sr+1, sr + 11):
        for c in range(sc+1, sc + 11):
            arr[r][c] = 1

# 1개수 세기
ans = 0
for r in range(0, 102):
    for c in range(0, 102):
        if arr[r][c] != arr[r][c-1]:
            ans += 1
        if arr[r][c] != arr[r-1][c]:
            ans += 1

print(ans)
