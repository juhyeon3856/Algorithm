N, M = map(int, input().split())
lst = list(map(int, input().split()))

mx = [0]


def combi(depth, start, sm):
    if sm > M:
        return
    if depth == 3:
        if sm > mx[0]:
            mx[0] = sm
        return
    for i in range(start, N):
        combi(depth + 1, i + 1, sm + lst[i])


combi(0, 0, 0)
print(mx[0])