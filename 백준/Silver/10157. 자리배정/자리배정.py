import sys
input = sys.stdin.readline


def main():
  N, M = map(int, input().split())
  K = int(input())
  arr = [[0]*M for _ in range(N)]
  # 우 하 좌 상 순서
  dr = [0, -1, 0, 1]
  dc = [1, 0, -1, 0]

  # 시작점
  r, c, d = 0, -1, 0


  cnt = 1
  while cnt <= N*M:
    r, c = r + dr[d], c + dc[d]
    if 0<=r<N and 0<=c<M:
      if arr[r][c] == 0:
        if cnt == K:
          return  (r+1, c+1)
        arr[r][c] = cnt
        cnt += 1
      else:
        r -= dr[d]
        c -= dc[d]
        d = (d+1)%4
    else:
      r -= dr[d]
      c -= dc[d]
      d = (d+1)%4
  return 0


ans = main()
if ans == 0:
  print(0)
else:
  print(ans[0], ans[1])