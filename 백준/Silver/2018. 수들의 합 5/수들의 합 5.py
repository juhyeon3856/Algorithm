# 조건
# N을 몇 개의 연속된 자연수의 합으로 나타내는 가지수를 알고 싶어한다

# 아이디어
# N을 i개의 연속된 자연수의 합으로 나타내는 방법은 1가지이다


N = int(input())
answer = 0
i = 1
while N / i > i // 2:
    # i가 짝수인 경우 아래 두가지 조건을 만족하면 +1
    # i로 나눈 나머지 == i//2
    # N // i > i // 2 (이게 안되면 break)
    if i % 2 == 0 and N % i == i // 2:
        answer += 1

    # i가 홀수인 경우 아래 두가지 조건을 만족하면 +1
    # 나머지가 0이어야함
    # N // i > i // 2 (이게 안되면 break)
    if i % 2 == 1 and N % i == 0:
        answer += 1
    i += 1

print(answer)
