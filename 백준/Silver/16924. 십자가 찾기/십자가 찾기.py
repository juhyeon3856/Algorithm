# 입력
N, M = map(int, input().split())
board = [list(input()) for _ in range(N)]

# 전처리
mboard = [[0] * M for _ in range(N)]  # 내가 놓은 십자기 위치
ans = []  # 필요한 십자가 적어둠


def check(r, c):
    return 0 <= r < N and 0 <= c < M


dr = [0, 0, -1, 1]
dc = [1, -1, 0, 0]

# 로직

# 십자가를 놓을 수 있는 위치 모두 확인
for r in range(1, N - 1):
    for c in range(1, M - 1):
        if board[r][c] != '*':
            continue
        size = 1
        while size <= 100:  # 십자가 크기
            for d in range(4):
                nr, nc = r + dr[d] * size, c + dc[d] * size
                if not check(nr, nc):  # 하나라도 범위밖이면
                    break
                if board[nr][nc] != '*':  # 십자가 자리 아니면
                    break
            else:  # 해당 size에 십자가 만들어지면

                # 십자가 위치 표시
                mboard[r][c] += 1
                for d in range(4):
                    nr, nc = r + dr[d] * size, c + dc[d] * size
                    mboard[nr][nc] += 1

                # 정답에 더하기
                ans.append([r + 1, c + 1, size])

                # size + 1
                size += 1

                debug = 0  # continue처리 잘 되는지 확인

                # break를 피해 continue
                continue
            break

# 십자가 놓은 위치와 board에 있는 위치가 모두 동일한지 확인
ans_len = len(ans)

for r in range(N):
    for c in range(M):
        if (board[r][c] == '*') ^ (mboard[r][c] > 0):  # 있어야할곳에 없거나 없어야할곳에 있으면 True
            ans_len = -1
            break

# 정답 출력
if ans_len == -1:
    print(-1)
else:
    print(ans_len)
    for a in ans:
        print(*a)