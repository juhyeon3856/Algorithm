def union(x, y):
    x, y = find(x), find(y)
    if x == y:  # 부모가 같으면 == 같은 집합이면
        return False

    #  큰쪽 부모를 작은쪽으로 만들기
    if r[x] > r[y]:
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

data = [list(map(int, input().split())) for _ in range(M)]
data.sort(key=lambda x: x[2])  # 가중치 작은 순으로 정렬

ans, cnt = 0, 0

for a, b, w in data:
    if union(a, b):  # 새로 합쳐졌으면
        ans, cnt = ans + w, cnt + 1

    if cnt == N - 1:
        break
print(ans)