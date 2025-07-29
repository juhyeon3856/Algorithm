# 아이디어
# 우상, 우, 하로 dfs돌리면서 도착하는 개수 셈
# 만약 더이상 가지 못하면 끝나는거임(그 밑은 어차피 못감)

N, M = map(int, input().split())
arr = [list(input()) for _ in range(N)]

# 우상, 우, 우하 순서
dr = [-1, 0, 1]


def dfs(fr, fc):
    arr[fr][fc] = 'o'
    if fc == M - 1:
        return True
    for d in range(3):
        nr, nc = fr + dr[d], fc + 1
        if 0 <= nr < N and arr[nr][nc] == '.':
            if dfs(nr, nc):
                return True
    return False


ans = 0
for r in range(N):
    if dfs(r, 0):
        ans += 1

print(ans)