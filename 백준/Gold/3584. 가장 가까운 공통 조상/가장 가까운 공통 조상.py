# 가장 가까운 공통 조상에서 자식 노드가 갈라진다.

import sys
sys.setrecursionlimit(10001)

T = int(input())


def dfs(num):
    result = 0    # num 포함, 아래 node1, node2개수
    if num in {node1, node2}:
        result += 1
    for nxt in adj[num]:
        result += dfs(nxt)
        if ans[0]: return result  # 답을 만났으면(dfs탈출)
    else:
        if result == 2:  # 양갈래에 있으면
            ans[0] = num
    return result


for t in range(1, T + 1):
    N = int(input())
    adj = [[] for _ in range(N + 1)]
    isRoot = [1] * (N + 1)  # 루트 구하기 위함

    # 간선 정보 입력받기
    for _ in range(1, N):
        p, c = map(int, input().split())
        adj[p].append(c)
        isRoot[c] = 0  # 자식이였던 적이 있으면 root일 수 없음

    # 두 노드 입력
    node1, node2 = map(int, input().split())

    # root 구하기
    isRoot[0] = 0
    root = isRoot.index(1)

    # 입력 완료! 로직 시작
    ans = [0]
    dfs(root)
    print(ans[0])
