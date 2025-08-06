# 문제 난이도의 합은 L보다 크거나 같고, R보다 작거나 같아야 한다.
# 다양한 문제를 경험해보기 위해 가장 어려운 문제와 가장 쉬운 문제의 난이도 차이는 X보다 크거나 같아야 한다.

N, L, R, X = map(int, input().split())
lst = list(map(int, input().split()))  # 문제 난이도


def subset(depth, tot, mn, mx, cnt):
    if tot > R:  # 난이도 양수 -> 푸르닝
        return
    if depth == N:
        if L <= tot and mx - mn >= X:
            ans[0] += 1
        return
    subset(depth + 1, tot + lst[depth], min(mn, lst[depth]), max(mx, lst[depth]), cnt + 1)
    subset(depth + 1, tot, mn, mx, cnt)


ans = [0]
subset(0, 0, 10000000, 0, 0)
print(ans[0])