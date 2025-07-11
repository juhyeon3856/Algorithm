n = int(input())
answer = 0

for _ in range(n):
  isExist = set()
  str = input()
  cs = ''
  isGroup = True
  for s in str:
    if cs == s: continue
    if s in isExist:
      isGroup = False
      break
    cs = s
    isExist.add(cs)
  if isGroup:
    answer+=1

print(answer)