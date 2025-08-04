import heapq
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
Tlst = [0, 0] + list(map(int, input().split()))  # i번째 도시에 머무르는 시간
adj = [[] for _ in range(N + 1)]

for _ in range(M):  # 간선 정보 입력
    s, e, t = map(int, input().split())
    adj[s].append([e, t])  # 다음 장소와 가중치

# 입력 완료! 로직 시작
queue_min = []
queue_max = []
heapq.heappush(queue_min, (0, 0, 1))  # 항공편 수, 걸린시간, 도시 인덱스
heapq.heappush(queue_max, (0, 0, 1))


def func(queue, delta):  # delta가 -1이면 역순 정렬
    while queue:
        cv, ct, ci = heapq.heappop(queue)  # 항공편수, 걸린 시간(가서 머무르는 시간 포함), 지금 도시
        if ci == 1 and ct:  # 다른곳을 거쳐서 1에 도착했으면
            return ct * delta
        if visited[ci]:  # 도착한적있으면
            continue
        visited[ci] = 1
        for ni, nw in adj[ci]:  # 일단 다 넣음 (lazy한 처리)
            nt = ct + (nw + Tlst[ni]) * delta  # ni까지 걸린시간은 이전에 걸린시간 + ni로 가는시간 + ni에 머무르는 시간
            nv = cv + 1
            heapq.heappush(queue, (nv, nt, ni))
    print("!!!!!!!!!!!!!!!!")  # 이런 입력 없어야함
    return -1


visited = [0] * (N + 1)  # 방문함 표시 : 처음 도착했을 때가 최대(혹은 최소)
print(func(queue_min, 1))
visited = [0] * (N + 1)  # 방문함 표시 : 처음 도착했을 때가 최대(혹은 최소)
print(func(queue_max, -1))