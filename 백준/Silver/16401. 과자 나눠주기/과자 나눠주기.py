# 8시 9분

# 이분탐색 -> 복잡도 : 30 * 1_000_000 -> 가능

M, N = map(int, input().split())
lst = list(map(int, input().split()))


def search():
    s, e = 1, 1_000_000_001
    result = 0
    while s < e:
        mid = (s + e) // 2

        if is_ok(mid):
            result = mid
            s = mid + 1
        else:
            e = mid
    return result


def is_ok(num):
    result = 0
    for l in lst:
        result += l // num

    return result >= M


print(search())