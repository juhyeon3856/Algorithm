# 1부터 gi사이에 있는 수 고를 것
# 10 ^ 5이므로 nlogn까지 가능
# union find
import sys

input = sys.stdin.read  # 표준 입력 전체를 한 번에 읽음
data = input().split()

G = int(data[0])
P = int(data[1])
lst = list(map(int, data[2:]))

p = [i for i in range(G + 1)]

# 나보다 작은 수 중 안쓴거 찾아보자
def find(x):
    result = x
    while p[result] < result:
        result = p[result]

    while p[x] < x:
        temp = x
        x = p[x]
        p[temp] = result
    return result


ans = 0
for i in range(P):
    f = find(lst[i])
    if f == 0:  # 더 이상 놓을 공간 없음
        break
    p[f] = f - 1
    ans += 1

print(ans)
