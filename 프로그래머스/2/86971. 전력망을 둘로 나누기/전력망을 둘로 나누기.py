def solution(n, wires):
    answer = n
    tree = [[0] for _ in range(n+1)]
    for l in wires:
        tree[l[0]].append(l[1])
        tree[l[1]].append(l[0])  
    for i in range(n+1):
        tree[i].pop(0)
    for a, b in wires:
        rst = CNT(a, b, tree, 0)
        rst = abs(2*rst - n)
        if rst < answer:
            answer = rst
    return answer

def CNT(a, b, tree, result):
    result += 1
    for e in tree[a]:
        if e != b:
            result = CNT(e, a, tree, result)
    return result