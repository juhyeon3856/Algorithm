N = int(input())

# 풀이 [1] 룩업테이블
# ver, diagU, diagD = [0] * N, [0] * (N + N - 1), [0] * (N + N - 1)
#
# def dfs(r):
#     if r == N:
#         ans[0] += 1
#         return
#     for c in range(N):
#         if ver[c] or diagU[r+c] or diagD[r-c]:  # 같은 열이나, 대각선에 이미 있으면
#             continue    # 패스
#         ver[c] = diagU[r+c] = diagD[r-c] = 1
#         dfs(r+1)
#         ver[c] = diagU[r + c] = diagD[r - c] = 0
#
#
# ans = [0]
# dfs(0)
# print(ans[0])


# 풀이 [2] bitmask
def dfs(r, ver, diagU, diagD):
    if r == N:
        ans[0] += 1
        return
    flag = ver | diagU | diagD
    for c in range(N):
        if flag & 1<<c: continue    # 놓을 수 없는 곳이면
        dfs(r+1, ver | 1<<c, (diagU | 1<<c)<<1, (diagD | 1<<c) >> 1)

ans = [0]
dfs(0, 0, 0, 0)
print(ans[0])