# [조건]
# 남학생은 스위치 번호가 자기가 받은 수의 배수이면, 그 스위치의 상태를 바꾼다.
# 여학생은 자기가 받은 수와 같은 번호가 붙은 스위치를 중심으로 좌우가 대칭이면서
# 가장 많은 스위치를 포함하는 구간을 찾아서, 그 구간에 속한 스위치의 상태를 모두 바꾼다.


N = int(input())
lst = [0] + list(map(int, input().split()))

M = int(input())


def boy(idx):
  # inx의 배수 뒤집기
  for i in range(idx,N+1,idx):
    lst[i] = not lst[i]



def girl(idx):
  s, e = idx, idx
  # 대칭인 구간 찾기
  while s-1 > 0 and e+1 <= N and lst[s-1] == lst[e+1]:
    s, e = s-1, e+1
  lst[s:e+1] = list(map(lambda x : not x, lst[s:e+1]))  # 뒤집기


for _ in range(M):
  g, idx = map(int, input().split())
  if g==1:
    boy(idx)
  else:
    girl(idx)

lst = list(map(int, lst))
start_index = 1
while start_index < len(lst):
  print(*lst[start_index : start_index+20])
  start_index += 20