def solution(x, y, n):
    if x==y:
        return 0
    q = [[x, 0]]
    lateCheck = {}
    while q:
        x, cnt = q.pop(0)
        for _x in [x + n, 2*x, 3*x ]:
            if _x == y:
                return cnt+1
            elif _x not in lateCheck and _x < y:
                lateCheck[_x] = 0
                q.append([_x, cnt+1])
    return -1