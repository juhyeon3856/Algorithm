# Alst에서 num찾기!
def search(num):
    s, e = 0, N  # [s, e)
    while s < e:
        mid = (s + e) // 2
        if Alst[mid] == num:  # mid번째가 목표값이면
            return 1  # 1리턴
        elif Alst[mid] < num:  # 작으면 뒤에서 찾아야함 -> 앞에 날려~
            s = mid + 1
        else:  # 크거나 같으면 앞에서 찾아야함 -> 뒤에 날려
            e = mid  # **end포함 안하므로 mid-1아니라 mid
    return 0  # 값이 없으면


# search test ** 꼭 해보기!
# N = 8
# Alst = [0, 1, 2, 3, 4, 7, 8, 10]
# Dlst = [-1, -2, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
# ans = [0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0]
# for i in range(len(Dlst)):
#     if search(Dlst[i]) != ans[i]:
#         print(Dlst[i])

# 입력
N = int(input())
Alst = list(map(int, input().split()))

M = int(input())
Dlst = list(map(int, input().split()))

# 전처리
ans = []
Alst.sort()

# 로직 시작!
for d in Dlst:
    ans.append(search(d))  # 이진탐색

# 정답 출력
print(*ans, sep="\n")