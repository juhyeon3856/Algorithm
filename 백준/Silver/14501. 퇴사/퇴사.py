# 시작시간 : 11시 42분
# 종료시간 : 11시 54분
# 소요시간 : 12분
# 제출횟수 : 1회

# 아이디어 : sebset + 상담일자만큼 depth를 jump

def subset(depth, tot):
    if depth >= N:  # 종료조건(N보다 넘어갈 수 있음)
        ans[0] = max(ans[0], tot)
        return
    # depth번째 상담을 선택하면 depth + arr[depth][0] -1 까지 상담해야하므로 다음 상담은 depth + arr[depth][0]
    if depth + arr[depth][0] <= N:
        subset(depth + arr[depth][0], tot + arr[depth][1])
    else:  # 상담 마치는 날짜가 N보다 커지면 그 상담은 할 수 없음
        subset(depth + arr[depth][0], tot)
    subset(depth + 1, tot)  # depth번째 상담 안하는 경우


N = int(input())
# 소요일, 금액
arr = [list(map(int, input().split())) for _ in range(N)]
ans = [0]  # 최대 이익
subset(0, 0)  # depth, tot
print(ans[0])