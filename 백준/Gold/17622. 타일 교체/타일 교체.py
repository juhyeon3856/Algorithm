N, K = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
dr = [(0, 1), (0, 1), (-1, 0), (-1, 0), (-1, 1), (0, 0)]
dc = [(1, 0), (-1, 0), (0, 1), (0, -1), (0, 0), (-1, 1)]
ds = ['┌', '┐', '└', '┘', '│', '─']


def myprint():
    # print(f"------------------------------")
    # for lst in arr:
    #     for d in lst:
    #         print(ds[d], end='')
    #     print()
    # print(f"점수 : {get_load(ans)}")
    return


def check(fr, fc):
    if (fr, fc) == (N - 1, N):
        return True
    return 0 <= fr < N and 0 <= fc < N


def get_load(init):
    visited = [[0] * N for _ in range(N)]

    cr, cc = 0, 0
    visited[cr][cc] = 1

    while (cr, cc) != (N - 1, N):
        for d in range(2):
            nr, nc = cr + dr[arr[cr][cc]][d], cc + dc[arr[cr][cc]][d]

            if not check(nr, nc):
                continue

            if (nr, nc) == (N - 1, N):
                return visited[cr][cc]

            if visited[nr][nc]:
                continue

            visited[nr][nc] = visited[cr][cc] + 1
            pr, pc = cr, cc
            cr, cc = nr, nc
            break
        else:
            return init

        for d in range(2):
            nr, nc = cr + dr[arr[cr][cc]][d], cc + dc[arr[cr][cc]][d]

            if (nr, nc) == (pr, pc):
                # if 0 <= nr < N and 0 <= nc < N and visited[nr][nc]:
                break
        else:
            return init

    return -2


if K == 0:
    ans = get_load(-1)
    print(ans)
else:
    ans = N * N * 100
    if arr[0][0] not in (1, 5):
        prev = arr[0][0]
        arr[0][0] = 1
        myprint()
        ans = min(ans, get_load(ans))
        arr[0][0] = 5
        myprint()
        ans = min(ans, get_load(ans))
    else:
        prev = arr[0][0]
        if prev == 1:
            arr[0][0] = 5
            myprint()
            ans = min(ans, get_load(ans))
            arr[0][0] = prev
        if prev == 5:
            arr[0][0] = 1
            myprint()
            ans = min(ans, get_load(ans))
            arr[0][0] = prev
        for r in range(N):
            for c in range(N):
                if (r, c) == (0, 0): continue
                prev = arr[r][c]
                for d in range(6):
                    if prev == d:
                        continue
                    arr[r][c] = d
                    myprint()
                    ans = min(ans, get_load(ans))
                    debug = 0
                arr[r][c] = prev
    if ans == N * N * 100:
        print(-1)
    else:
        print(ans)
