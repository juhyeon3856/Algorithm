st = input()
stack = []
while st != '.':
  ans = 'yes'
  for s in st:
    if s == '(' or s == '[':
      stack.append(s)
    if s == ')':
      if stack and stack[len(stack)-1] == '(':
        stack.pop(len(stack)-1)
      else:
        ans = 'no'
    if s == ']':
      if stack and stack[len(stack) - 1] == '[':
        stack.pop(len(stack) - 1)
      else:
        ans = 'no'
  # 남아있으면
  if stack:
    ans = 'no'
  print(ans)
  st = input()
  stack.clear()