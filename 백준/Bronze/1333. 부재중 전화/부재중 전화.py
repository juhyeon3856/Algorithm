N, L, D = map(int, input().split())

ans = D * (((N * L) + 5 * (N - 1) - 1) // D + 1)
dt = 0
st, et = L, L + 5


def is_ans():
    global dt, ans
    while et > dt:
        if st <= dt:
            ans = dt
            return True
        dt += D
    return False


for i in range(N-1):
    if is_ans():
        break
    st, et = et + L, et + L + 5

print(ans)