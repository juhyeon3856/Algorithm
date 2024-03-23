from collections import deque

def solution(n, edge):
    inf = 1e9
    length = [inf] * (n+1)
    length[0] = -1
    length[1] = 0
    tree = makeTree(edge, n)
    check = [True] * (n+1)
    check[1] = False
    queue = deque([1])
    while queue:
        q = queue.popleft()
        for n in tree[q]:
            if check[n]:
                length[n] = length[q]+1
                queue.append(n)
                check[n] = False
    return length.count(max(length))

def makeTree(info, n):
    tree = [[] for _ in range(n+1)]
    for i, j in info:
        tree[i].append(j)
        tree[j].append(i)
    return tree