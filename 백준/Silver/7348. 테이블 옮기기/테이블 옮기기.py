# 8시 20분

# 주의 사항 : 정렬하기
# 8시 27분

from heapq import heappop, heappush

TC = int(input())

for tc in range(1, TC + 1):
    N = int(input())
    arr = [list(map(lambda x: (int(x) + 1) // 2, input().split())) for _ in range(N)]

    # 전처리
    # 시작, 끝 정렬
    for i in range(N):
        arr[i].sort()

    # 이동 별 끝나는 시간 정렬
    arr.sort(lambda x: (x[0], x[1]))

    pq = [-1]

    # 로직
    for s, e in arr:
        if s > pq[0]:
            heappop(pq)
            heappush(pq, e)
        else:
            heappush(pq, e)

    # 정답
    print(len(pq) * 10)

# 08:40