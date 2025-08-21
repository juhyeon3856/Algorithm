# 시작시간 8시 11분

N = int(input())

lst = list(map(int, input().split()))
lst.sort()

print(lst[0] * lst[-1])