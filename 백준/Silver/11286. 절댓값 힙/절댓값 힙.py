# 아이디어
# [A] 양수와 음수를 따로 pq에 넣어서 관리한다.
# [B] 음수는 절댓값을 사용하므로 부호를 바꿔서 저장한다.

from heapq import heappush, heappop, heapify

# 입력
N = int(input())
_pq, pq = [], []  # 음수를 넣을 _pq, 양수를 넣을 pq
ans = []  # 정답 순서대로 넣을 것임

for _ in range(N):
    num = int(input())
    if num < 0:  # 음수이면
        heappush(_pq, -num)  # _pq에 넣기 ...[B]
    elif num > 0:  # 양수이면
        heappush(pq, num)  # pq에 넣기
    else:  # 0이면
        if pq and _pq:  # pq, _pq 둘다 수 존재하면
            if _pq[0] <= pq[0]:  # 절댓값 작은 수 출력
                ans.append(-heappop(_pq))
            else:  # pq < _pq
                ans.append(heappop(pq))
        elif pq:  # _pq는 없고 pq만 있으면
            ans.append(heappop(pq))
        elif _pq:
            ans.append(-heappop(_pq))
        else:  # 둘다 없으면
            ans.append(0)


# 정답 출력
print(*ans, sep="\n")