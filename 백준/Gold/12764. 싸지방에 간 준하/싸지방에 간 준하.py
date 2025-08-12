from heapq import heappop, heappush, heapify


# 크거나 같은 값 중 최솟값 찾기
# def search(num):
#     result = 1_000_001
#     s, e = 0, N
#     while s < e:
#         mid = (s + e) // 2
#         if arr[mid][0] >= num:
#             result = arr[mid][0]
#             e = mid
#         else:
#             s = mid + 1
#     return result


# 입력
N = int(input())  # 사람수
arr = [list(map(int, input().split())) for _ in range(N)]

# TEST
# for n in (50, 100, 40, 110, 90):
#     print(search(n))

# 전처리
arr.sort(key=lambda x: (x[0], x[1]))
# for lst in arr:
#     lst.append(search(lst[1]))
ans = [0] * N  # 컴퓨터 별 이용자 수
pq = [(-1, 0)]  # 컴퓨터 정보를 담을 pq (다음번에 시작 시간, 번호)

# 로직
# 아이디어 : 종료시간이 start_time[0]보다 컴퓨터 번호 작은 순으로 사용
# -> [A] 기존 컴퓨터에 이어서 사용할 수 있으면 그대로 사용,
# -> [B] 모든 컴퓨터가 이미 사용중이면 새로운 컴퓨터 사용
can_use = []
for s, e in arr:
    while pq and pq[0][0] <= s: # 사용 가능한 컴퓨터 번호 다 빼기
        heappush(can_use, heappop(pq)[1])
    if can_use: # 사용 가능한 컴퓨터 있으면
        pc_no = heappop(can_use)
        ans[pc_no] += 1
        heappush(pq, (e, pc_no))
    else:
        llen = len(pq)
        ans[llen] += 1
        heappush(pq, (e, llen))

# 정답 출력
pq_len = len(pq) + len(can_use)
print(pq_len)
print(*ans[:pq_len])
