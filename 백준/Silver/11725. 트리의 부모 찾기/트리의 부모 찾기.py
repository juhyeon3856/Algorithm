import sys
sys.setrecursionlimit(110000)

N = int(input())

adj = [[] for _ in range(N + 1)]
ans = [0] * (N + 1)  # 각각의 부모 노드 저장


def dfs(prev):
    for nxt in adj[prev]:
        if ans[nxt]:  # 이미 부모 있음
            continue  # visited와 같은 역할
        ans[nxt] = prev
        dfs(nxt)


for _ in range(1, N):
    s, e = map(int, input().split())
    adj[s].append(e)
    adj[e].append(s)

# 입력 완료! 로직 시작
dfs(1)  # root node = 1

# 정답 출력
for i in range(2, N + 1):
    print(ans[i])