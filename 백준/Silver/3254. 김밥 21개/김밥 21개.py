# 던지면 map에 적고 승자가 있는지 확인함


# 상우, 우, 우하, 하
dr = [-1, 0, 1, 1]
dc = [1, 1, 1, 0]
def is_start(r, c, d):
  if board[r][c] == '.':
    return False
  nr, nc = r + dr[d] * -1, c + dc[d]  * - 1
  if 0 <= nr < N and 0 <= nc < M:
    if board[nr][nc] == board[r][c]:
      return False
  return True

# 시작점이 r, c인 곳에서 4방으로 4개가 있는지 확인
def is_four(r, c):
  for d in range(4):
    if is_start(r, c, d):  # 시작점이면
      for i in range(4):
        nr = r + dr[d] * i
        nc = c + dc[d] * i
        if 0<=nr<N and 0<=nc<M:
          if board[r][c] != board[nr][nc]:
            break
        else: break
      else:
        return board[r][c]
  return ""


# 승자가 있는지 확인하는 함수
def is_win():
  for r in range(N):
    for c in range(M):
      if is_four(r, c):
        return board[r][c]
  return ""


# 던졌을 때 map을 바꾸는 함수
def go_step(idx):
  sang, jung = arr[idx]
  board[height[sang]][sang] = 'sk'
  height[sang] += 1
  board[height[jung]][jung] = 'ji'
  height[jung] += 1


N, M, R = 6, 7, 21
arr = [list(map(lambda x : int(x) - 1, input().split())) for _ in range(R)]
board = [['.'] * M for _ in range(N)]
height = [0] * M

for i in range(21):
  go_step(i)
  result = is_win()
  if result:
    print(result, i+1)
    break
else:
  print("ss")