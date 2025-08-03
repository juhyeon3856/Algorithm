# 킹이 이동할 위치에 돌이 있으면 돌도 한칸 밀기

# 방향 선언
dic = {'R': (0, 1), 'L': (0, -1), 'B': (-1, 0), 'T': (1, 0), 'RT': (1, 1), 'LT': (1, -1), 'RB': (-1, 1), 'LB': (-1, -1)}


def check(fr, fc):  # 범위 체크 함수
    return 0 <= fr < N and 0 <= fc < N


K, S, M = input().split()
N = 8

kr, kc = int(K[1]) - 1, ord(K[0]) - 65
sr, sc = int(S[1]) - 1, ord(S[0]) - 65
M = int(M)

for _ in range(M):
    go = input()
    nkr, nkc = kr + dic.get(go)[0], kc + dic.get(go)[1]
    if not check(nkr, nkc):  # king이 범위 밖이면
        continue
    if (nkr, nkc) == (sr, sc):  # 돌이 있는 자리이면
        nsr, nsc = sr + dic.get(go)[0], sc + dic.get(go)[1]  # 돌도 이동
        if not check(nsr, nsc):  # 돌이 범위 밖이면
            continue
        sr, sc = nsr, nsc  # 돌 이동
    kr, kc = nkr, nkc  # 왕 이동

# 답 출력
print(chr(kc + 65), end="")
print(kr + 1)
print(chr(sc + 65), end="")
print(sr + 1)
