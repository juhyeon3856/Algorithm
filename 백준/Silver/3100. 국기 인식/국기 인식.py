import sys
input = sys.stdin.readline

# 가로, 세로 따로 함
# 많은거 우선순위로 개수 셈
# 9가지 경우 중 가능한 경우 후보로 둠


# sr, sc, er, ec사이의 색상 개수를 세주는 함수
def count_color(sr, sc, er, ec):
  cnt = [[idx, 0] for idx in range(26)]
  for r in range(sr, er):
    for c in range(sc, ec):
      cnt[ord(arr[r][c]) - 65][1] += 1
  
  cnt.sort(key= lambda x : -x[1])
  return cnt[:3]

# 가로로 분리함
def check1():
  line1, line2, line3 = count_color(0, 0, N//3, M), count_color(N//3, 0, N//3 * 2, M), count_color(N//3 * 2, 0, N, M)
  result = 0 # 바꾸지 않아도 되는 색상 수 
  for i in range(3):
    for j in range(3):
      for k in range(3):
        # 이웃하는 두 영역의 생상이 같으면 continue
        if line1[i][0] == line2[j][0] or line2[j][0] == line3[k][0]:
          continue
        _result = line1[i][1] + line2[j][1] + line3[k][1]
        result = max(result, _result)
    return result


  
# 세로로 분리함
def check2():
  line1, line2, line3 = count_color(0, M//3 * 0, N, M//3 * 1), count_color(0, M//3 * 1, N, M//3 * 2), count_color(0, M//3 * 2, N, M//3 * 3)
  result = 0 # 바꾸지 않아도 되는 색상 수 
  for i in range(3):
    for j in range(3):
      for k in range(3):
        # 이웃하는 두 영역의 생상이 같으면 continue
        if line1[i][0] == line2[j][0] or line2[j][0] == line3[k][0]:
          continue
        _result = line1[i][1] + line2[j][1] + line3[k][1]
        result = max(result, _result)
    return result




N, M = 6, 9
arr = [list(input()) for _ in range(N)]

print(N*M - max(check1(), check2()))
