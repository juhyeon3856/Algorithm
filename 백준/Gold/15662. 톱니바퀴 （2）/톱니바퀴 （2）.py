T = int(input())


# 다음 것 돌릴건지
def move(idx, fdi):
    if idx + delta < 0 or idx + delta >= T:  # ????????????????/
        return

    if arr[idx][(ilst[idx] + pi) % 8] != arr[idx + delta][(ilst[idx + delta] + ni) % 8]:  # 다르면 돌아감
        move(idx + delta, fdi * -1)
        # 돌리자
        ilst[idx + delta] = (ilst[idx + delta] + dd[fdi]) % 8


arr = [list(map(int, input())) for _ in range(T)]
ilst = [0] * T
dd = [0, 7, 1]

K = int(input())

for _ in range(K):
    ti, di = map(int, input().split())
    ti = ti - 1
    # 오른쪽
    delta, pi, ni = 1, 2, 6
    move(ti, di * -1)
    debuf = 0

    # 왼쪽
    delta, pi, ni = -1, 6, 2
    move(ti, di * -1)
    debuf = 0

    # 본인
    ilst[ti] = (ilst[ti] + dd[di]) % 8
    debuf = 0

ans = 0
for i in range(T):
    ans += arr[i][ilst[i]]

print(ans)