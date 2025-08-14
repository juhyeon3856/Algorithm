# 예상 시간 복잡도 : N


# delta 방향으로 연속해서 높은 것의 개수를 센다.
def cnt_height(si, ei, delta):
    result = [0] * (N + 2)
    stack = []

    for idx in range(si, ei, delta):
        #  stack에서 꺼내진 개수 idx에 저장
        while stack and stack[-1][0] > height[idx]:  # 다음 것이 stack 맨 위보다 작으면
            _, ci = stack.pop()  # idx를 꺼낸서
            result[ci] = delta * (idx - ci)  # 개수 저장

        stack.append((height[idx], idx))  # 넣기

    return result


ans = []
lst = list(map(int, input().split()))
while lst[0]:
    N = lst[0]
    height = [-1] + lst[1:] + [-1]

    right = cnt_height(1, N + 2, 1)
    left = cnt_height(N, -1, -1)

    square = [height[i] * (left[i] + right[i] - 1) for i in range(N + 2)]
    ans.append(max(square[1:N + 1]))
    lst = list(map(int, input().split()))

print(*ans, sep="\n")