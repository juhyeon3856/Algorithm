from collections import deque

adj = []
adj.append([16, 22, 18, 25])  # A 0   65
adj.append([21, 6, 7, 13])  # B 1
adj.append([23, 3, 5, 21])  # C 2
adj.append([4, 17, 5, 2, 23, 18])  # D 3
adj.append([22, 18, 3, 17])  # E 4
adj.append([17, 19, 6, 21, 2, 3])  # F 5
adj.append([19, 24, 7, 1, 21, 5])  # G 6
adj.append([24, 20, 9, 13, 1, 6])  # H 7
adj.append([20, 9, 10, 14])  # I 8
adj.append([20, 8, 10, 12, 13, 7])  # J 9
adj.append([8, 14, 11, 12, 9])  # K 10
adj.append([14, 15, 10])  # L 11
adj.append([13, 9, 10])  # M 12
adj.append([1, 7, 9, 12])  # N 13
adj.append([8, 10, 11, 15])  # O 14
adj.append([14, 11])  # P 15
adj.append([22, 0])  # Q 16
adj.append([4, 3, 5, 19])  # R 17
adj.append([0, 22, 4, 3, 23, 25])  # S 18
adj.append([17, 5, 6, 24])  # T 19
adj.append([24, 7, 9, 8])  # U 20
adj.append([2, 5, 6, 1])  # V 21
adj.append([16, 0, 18, 4])  # W 22
adj.append([25, 18, 3, 2])  # X 23
adj.append([19, 6, 7, 20])  # Y 24
adj.append([0, 18, 23])  # Z 25


# 인접리스트 생성 완료!
def cnt(s, e):
    visited = [0] * 26
    queue = deque([s])
    visited[s] = 1

    while queue:
        q = queue.popleft()
        if q == e:
            break
        for nxt in adj[q]:
            if visited[nxt]:  # 방문했으면
                continue
            visited[nxt] = visited[q] + 1
            queue.append(nxt)

    return visited[e] - 1


T = int(input())

for t in range(1, T + 1):
    st = input()
    N = len(st)
    ans = N
    for i in range(1, N):
        ans += 2 * cnt(ord(st[i-1]) - 65, ord(st[i]) - 65)
    print(ans)