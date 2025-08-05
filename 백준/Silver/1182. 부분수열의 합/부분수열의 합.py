N, S = map(int, input().split())
lst = list(map(int, input().split()))


def subset(depth, sum, cnt):    # 깊이, 더한 값, 선택한 개수
    if depth == N:
        if cnt and sum == S:    # 선택한게 있는데 sum 이 S와 같으면
            ans[0] += 1
        return

    subset(depth + 1, sum + lst[depth], cnt + 1)  # depth번째 수를 선택하는 경우
    subset(depth + 1, sum, cnt)  # depth번째 수를 선택하지 않는 경우


ans = [0]  # 전역 사용
subset(0, 0, 0)
print(ans[0])