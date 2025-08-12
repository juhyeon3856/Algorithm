from heapq import heappop, heappush, heapify

# 입력
N = int(input())
lst = [int(input()) for _ in range(N)]

# 전처리
heapify(lst)  # pq로 바꿔주기
ans = 0  # 비교 횟수 더해주기

# 로직
# 아이디어: heapq에 넣어서 크기가 작은 순으로 2개를 뽑아 합친다.
while len(lst) > 1:
    _ans = heappop(lst) + heappop(lst)  # 작은 순 2개 뽑아서 더하기(비교횟수)
    ans += _ans
    heappush(lst, _ans)  # 다시 넣기(또 비교해야함)

# 정답 출력
print(ans)