# 자식부터 부모로 올라간다.
# 최초로 2개가 되는 곳에서 멈춘다.

T = int(input())

for t in range(1, T + 1):
    N = int(input())
    adj = [0] * (N + 1)  # 부모 정보 저장

    # 간선 정보 입력받기
    for _ in range(1, N):
        p, c = map(int, input().split())
        adj[c] = p  # 자식에 부모를 저장

    # 두 노드 입력
    node1, node2 = map(int, input().split())
    parents1, parents2 = [node1], [node2]

    # 부모 만나는 순으로 저장
    while adj[node1]:  # node1부터 시작해서 부모 저장
        node1 = adj[node1]
        parents1.append(node1)
    while adj[node2]:  # node2부터 시작해서 부모 저장
        node2 = adj[node2]
        parents2.append(node2)

    # 공통 부모 찾기
    cnt = [0] * (N + 1)  # parents배열에 나온 횟수 저장
    for p1 in parents1:  # p1에 대한 cnt 반영
        cnt[p1] += 1

    for p2 in parents2:  # p2에 대한 cnt 반영
        cnt[p2] += 1
        if cnt[p2] == 2:  # p1에도 있었고, p2에도 있었으면
            print(p2)  # 정답 출력
            break  # 처음 만난게 젤 가까운 부모노드