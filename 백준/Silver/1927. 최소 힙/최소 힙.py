from heapq import heappush, heappop, heapify

# 입력
N = int(input())
pq = []  # heapq 리스트
ans = []  # 정답 순서대로 넣을 것임

for _ in range(N):
    num = int(input())
    if num:  # 자연수이면 
        heappush(pq, num)  # pq에 넣기
    elif pq:  # 0인데 pq에 값 있으면
        ans.append(heappop(pq))
    else:  # 0인데 pq에 값 없으면
        ans.append(0)  # 0출력

# 정답 출력
print(*ans, sep="\n")