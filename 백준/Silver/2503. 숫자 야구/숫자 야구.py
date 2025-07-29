N = int(input())

arr = [list(map(int, input().split())) for _ in range(N)]


def result(num1, num2):
    result = [0, 0]
    num1 = [num1 // 100, num1 % 100 // 10, num1 % 10]
    num2 = [num2 // 100, num2 % 100 // 10, num2 % 10]
    for i in range(3):
        for j in range(3):
            if num1[i] == num2[j]:  # 같은 숫자 있으면
                if i == j:  # 위치도 같으면
                    result[0] += 1  # 스트라이크 += 1
                else:  # 위치는 다르면
                    result[1] += 1  # 볼 += 1
    return result


def check(num):
    for n, s, b in arr:
        if [s, b] != result(num, n):
            return 0
    return 1


ans = 0
for i in range(1, 10):
    for j in range(1, 10):
        for k in range(1, 10):
            if i==j or j==k or k==i:
                continue
            ans += check(i * 100 + j * 10 + k)
print(ans)
