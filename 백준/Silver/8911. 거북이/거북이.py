T = int(input())

dic = {'F': 1, 'L': -1, 'R': 1, 'B': -1}

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

for _ in range(T):
    cmds = input()
    cx, cy, cd = 0, 0, 0  # 0, 0에서 시작, 처음 북쪽
    mnx, mny, mxx, mxy = 0, 0, 0, 0  # 움직인 장소 중 x, y최소 최대

    for cmd in cmds:
        if cmd in {'F', 'B'}:  # 전진 혹은 후진
            cx, cy = cx + dx[cd] * dic.get(cmd), cy + dy[cd] * dic.get(cmd)
            mnx, mny, mxx, mxy = min(cx, mnx), min(cy, mny), max(cx, mxx), max(cy, mxy)
        else:  # 방향 전환
            cd = (cd + dic.get(cmd)) % 4
        debug = 0  # 이동 확인

    print((mxx - mnx) * (mxy - mny))