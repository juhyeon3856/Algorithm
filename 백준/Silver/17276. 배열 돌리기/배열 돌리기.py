T = int(input())


def move(delta):
    sta, mid, end = 0, N // 2, N - 1
    ds = [(sta, sta), (sta, mid), (sta, end), (mid, end), (end, end), (end, mid), (end, sta), (mid, sta)]
    # de = [(end, end), (end, mid), (end, sta), (mid, sta), (sta, sta), (sta, mid), (sta, end), (mid, end)]
    dd = [(1, 1), (1, 0), (1, -1), (0, -1), (-1, -1), (-1, 0), (-1, 1), (0, 1)]

    ni = delta
    for pi in range(8):
        move_line(ds[pi], dd[pi], ds[ni], dd[ni])
        ni = (ni + 1) % 8


def move_line(ps, pd, ns, nd):
    psr, psc = ps
    nsr, nsc = ns
    for d in range(N):
        ans[nsr][nsc] = arr[psr][psc]
        psr, psc = psr + pd[0], psc + pd[1]
        nsr, nsc = nsr + nd[0], nsc + nd[1]


def print_ans():
    for lst in ans:
        print(*lst)


for t in range(1, T + 1):
    # 입력
    N, M = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(N)]
    ans = [arr[i][:] for i in range(N)]

    # 전처리
    M = ((M + 360) % 360) // 45

    # 회전 로직
    move(M)

    # 정답 출력
    print_ans()
