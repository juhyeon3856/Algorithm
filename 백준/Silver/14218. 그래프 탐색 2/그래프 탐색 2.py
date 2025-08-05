# bfs한번만 돌리고 prev, nxt를 저장해서 연결 될 때 마다 업데이트 하는 방식
# 시간 복잡도 (N+M+Q)*Q에서 (M+Q)*Q로 줄어들 듯 -> 사실상 (N+Q)*Q일수도?
# 입출력 수정# 입출력 수정(jos***97님 참고)

from collections import deque

inp = open(0)
N, M = map(int, next(inp).split())
adj = [[] for _ in range(N + 1)]

# 인접리스트 만들기
for _ in range(M):
    a, b = map(int, next(inp).split())
    adj[a].append(b)
    adj[b].append(a)  # 양방향


def init():  # N+M   # 자기 다음으로 가야하는 노드를 기억함
    result_cnt = [-1] * (N + 1)
    queue = deque([1])
    result_cnt[0] = result_cnt[1] = 0

    while queue:
        cur = queue.popleft()
        for nxt in adj[cur]:
            if result_cnt[nxt] > -1:  # 이미 방문한 적 있으면
                continue
            queue.append(nxt)
            result_cnt[nxt] = result_cnt[cur] + 1
    return result_cnt


def update(n):  # p -> n으로 연결
    queue = deque([n])  # n부터 n에서 연결된 것들을 업데이트
    while queue:
        c = queue.popleft()
        for nn in adj[c]:
            if cnt[nn] != -1 and cnt[nn] <= cnt[c] + 1: continue
            cnt[nn] = cnt[c] + 1
            queue.append(nn)  # 최단거리이므로 루프 가능성 없음


Q = int(next(inp))
cnt = init()  # bfs는 이때 한번만 돌림
ans = []
for _ in range(Q):  # 500
    a, b = map(int, next(inp).split())
    adj[a].append(b)  # a에 b 연결하기 : a -> b
    adj[b].append(a)  # b에 a 연결하기 b -> a
    if cnt[a] == cnt[b] == -1:  # 둘다 -1인 경우 서로 연결
        pass
    elif cnt[a] == -1:
        cnt[a] = cnt[b] + 1
        update(a)
    elif cnt[b] == -1:
        cnt[b] = cnt[a] + 1
        update(b)
    elif cnt[a] > cnt[b] + 1:
        cnt[a] = cnt[b] + 1
        update(a)
    elif cnt[a] + 1 < cnt[b]:
        cnt[b] = cnt[a] + 1
        update(b)
    ans.append(cnt[1:])
    # print(*cnt[1:])

print('\n'.join((' '.join(map(str, i)) for i in ans)))