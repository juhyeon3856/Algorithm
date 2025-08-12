# 아이디어
# [A] 최댓값을 찾을 것이므로 음수로 넣고 부호 바꿔서 출력한다.
from heapq import heappush, heappop, heapify

# 입력
N = int(input())
pq = []  # heapq 리스트
ans = []  # 정답 순서대로 넣을 것임

for _ in range(N):
    num = int(input())
    if num:  # 자연수이면 
        heappush(pq, -num)  # pq에 넣기 ...[A]
    elif pq:  # 0인데 pq에 값 있으면
        ans.append(-heappop(pq))
    else:  # 0인데 pq에 값 없으면
        ans.append(0)  # 0출력

# 정답 출력
print(*ans, sep="\n")