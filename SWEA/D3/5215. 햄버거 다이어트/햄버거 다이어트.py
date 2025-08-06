# 행버거 다이어트
# 시작시간 : 9시 40분
# 제출시간 : 9시 48분
# 소요시간 : 8분
# 아이디어 : subset
# 제출횟수 : 1회

def subset(depth, score, kcal):
    if kcal > L:  # 칼로리를 이미 넘었으면
        return
    # 여기 들어오는 것은 전부 제한 칼로리 이하 조합
    if depth == N:
        ans[0] = max(ans[0], score)
        return
    subset(depth + 1, score + arr[depth][0], kcal + arr[depth][1])
    subset(depth + 1, score, kcal)


T = int(input())
for t in range(1, T + 1):
    N, L = map(int, input().split())
    # 점수, 칼로리
    arr = [list(map(int, input().split())) for _ in range(N)]
    ans = [0]  # 점수 최댓값
    subset(0, 0, 0)  # depth, score, kcal
    print(f"#{t} {ans[0]}")