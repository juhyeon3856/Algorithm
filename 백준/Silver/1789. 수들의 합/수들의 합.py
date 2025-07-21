import sys

input = sys.stdin.readline
S = int(input())

n = int((2*S)**(0.5))

while n*(n+1) > S * 2:
    n-=1
print(n)