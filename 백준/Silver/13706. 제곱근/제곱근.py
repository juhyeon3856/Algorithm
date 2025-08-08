# 1부터 N까지 중 제곱해서 N되는 수 찾기
def search(num):
    s, e = 1, num + 1  # [s, e)
    while s < e:
        mid = (s + e) // 2
        mid2 = mid * mid
        if mid2 == num:  # 정답이면
            return mid
        elif mid2 < num:  # mid가 더 커져야함
            s = mid + 1
        else:  # mid가 더 작아져야함
            e = mid
    return -1  # 이런경우 없음


N = int(input())
print(search(N))

# test
# end = 10 ** 400
# print(search(end*end))
# for i in range(1, 100):
#     if i != search(i * i):
#         print(i*i, search(i * i))