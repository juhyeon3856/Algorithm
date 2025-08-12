from collections import deque

# 입력
N, M = map(int, input().split())
Alst = [list(map(int, input().split()))[1:] for _ in range(N)]
B = list(map(int, input().split()))  # 초밥 종료

# 전처리
arr = [deque([]) for _ in range(200_001)]  # 조밥 종류 별 대기자 명단 -> 작은 순

for i in range(N):
    for n in Alst[i]:
        arr[n].append(i)  # n번 초밥 대기줄에 i추가

ans = [0] * N  # i번째 손님이 먹은 초밥 수

# 로직
# 아이디어 : bi번째 초밥이 나오면 arr[bi]의 첫 대기자에게 초밥 주기
for b in B:
    if arr[b]:  # 대기자가 있으면
        ans[arr[b].popleft()] += 1

# 정답 출력
print(*ans)