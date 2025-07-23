# import sys
# input = sys.stdin.readline

a, b, c = map(int, input().split())

# 같은 눈이 3개가 나오면 10,000원+(같은 눈)×1,000원의 상금을 받게 된다.
if a==b and b==c:
    print(10000 + a*1000)
# 같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)×100원의 상금을 받게 된다.
elif a==b or b==c or c==a:
    print(1000 + (a+b+c - (a^b^c))*50)
# 모두 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈)×100원의 상금을 받게 된다.
else:
    print(max(a, b, c) * 100)