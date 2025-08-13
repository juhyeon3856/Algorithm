import sys

sys.setrecursionlimit(10 ** 5)


def union(x, y):
    x, y = find(x), find(y)
    if x == y:  # 부모가 같으면 == 같은 집합이면
        return False

    #  큰쪽 부모를 작은쪽으로 만들기
    if r[x] < r[y]:
        p[y] = x
        r[x] += r[y]
    else:
        p[x] = y
        r[y] += r[x]

    return True


def find(x):
    if x != p[x]:  # 내가 대장이 아니면
        p[x] = find(p[x])  # 대장 찾기
    return p[x]


# 로직 시작!

N, M = map(int, input().split())
p = [i for i in range(N + 1)]  # 부모 배열 초기화
r = [1 for _ in range(N + 1)]
ans = []

for _ in range(M):  # 입력 받기
    t, a, b = map(int, input().split())

    if t == 0:  # 합집합
        union(a, b)
    else:
        ap, bp = find(a), find(b)
        if ap == bp:  # 같은 집합이면
            ans.append("YES")
        else:  # 같은 집합이 아니면
            ans.append("NO")

print(*ans, sep="\n")
