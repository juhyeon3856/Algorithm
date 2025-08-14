def calc_rangeX(x, y):
    x, y = int(x), int(y)
    delta = L - y
    return x - delta, x + delta


def search(mn, mx):
    s, e = 0, M

    while s < e:
        mid = (s + e) // 2
        if xlst[mid] < mn:
            s = mid + 1
        elif xlst[mid] > mx:
            e = mid
        else:
            return True
    return False


M, N, L = map(int, input().split())
xlst = list(map(int, input().split()))  # 사대 위치
alst = [list(map(int, input().split())) for _ in range(N)]

xlst.sort()
ans = 0

for x, y in alst:
    mmn, mmx = calc_rangeX(x, y)
    if mmn <= mmx and search(mmn, mmx):
        ans += 1

print(ans)