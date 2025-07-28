# 조건
# N번쨰 줄어드는 수

# 아이디어
# bfs로 구하기
# 앞 자리 수가 정해지면 그 다음 자리 보다 작은 수만 가능
#

from collections import deque

N = int(input())

queue = deque([9, 8, 7, 6, 5, 4, 3, 2, 1, 0])

while queue:
    N -= 1
    q = queue.pop()
    if N == 0:
        print(q)
        break
    for i in range(q%10):   # 앞 자리수보다 작은 수만 올 수 있음
        queue.appendleft(q * 10 + i)

if N > 0:
    print(-1)