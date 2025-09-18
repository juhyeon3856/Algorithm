N, K = map(int, input().split())
arr = [[5] * (N + 2)] + [[4] + list(map(int, input().split())) + [4] for _ in range(N)] + [[5] * (N + 2)]
arr[1][0], arr[N][N + 1] = 5, 5

dr = ((0, 1), (0, 1), (-1, 0), (-1, 0), (-1, 1), (0, 0))
dc = ((1, 0), (-1, 0), (0, 1), (0, -1), (0, 0), (1, -1))
ds = ['┌', '┐', '└', '┘', '│', '─']


def myprint(v):
    print(f"------------------------------")
    for lst in arr:
        for d in lst:
            print(ds[d], end='')
        print()
    print(f"점수 : {v}")
    return


def check(fr, fc):
    return 0 <= fr < N + 2 and 0 <= fc < N + 2


def is_conn(r1, c1, t1, r2, c2, t2):  # 서로에서 서로로 갈 수 있는지
    g1 = (r2, c2) in ((r1 + dr[t1][0], c1 + dc[t1][0]), (r1 + dr[t1][1], c1 + dc[t1][1]))
    g2 = (r1, c1) in ((r2 + dr[t2][0], c2 + dc[t2][0]), (r2 + dr[t2][1], c2 + dc[t2][1]))
    return g1 and g2


def is_go():
    result = -1
    pr, pc = -1, -1
    cr, cc = 1, 0
    while (cr, cc) != (N, N + 1):
        for d in range(2):
            nr, nc = cr + dr[arr[cr][cc]][d], cc + dc[arr[cr][cc]][d]

            if not check(nr, nc):
                continue

            if (nr, nc) == (pr, pc):
                continue

            if not is_conn(cr, cc, arr[cr][cc], nr, nc, arr[nr][nc]):
                continue

            pr, pc = cr, cc
            cr, cc = nr, nc
            result += 1
            break
        else:
            return -1

    return result


if K == 0:
    print(is_go())  # 못가면 -1
else:
    rs = is_go()
    if rs != -1 and rs != N * N:
        ans = rs
    else:
        ans = N * N * 100
    for r in range(1, N + 1):
        for c in range(1, N + 1):
            prev = arr[r][c]
            for t in range(6):
                if t == prev:
                    continue

                rr, cc = r + dr[t][0], c + dc[t][0]
                if not is_conn(r, c, t, rr, cc, arr[rr][cc]):  # 연결 안되어있으면
                    continue

                rr, cc = r + dr[t][1], c + dc[t][1]
                if not is_conn(r, c, t, rr, cc, arr[rr][cc]):  # 연결 안되어있으면
                    continue

                arr[r][c] = t
                rs = is_go()
                if rs != -1 and rs < ans:
                    ans = rs
                # myprint(rs)
            arr[r][c] = prev
    if ans == N * N * 100:
        print(-1)
    else:
        print(ans)
