sset = {'1', '2', '3', '4', '5', '6', '7', '8', '9'}
dic = {'H': 1, 'C': 12, 'O': 16}

st = list(input())
N = len(st)
# 괄호 붙이기
for i in range(N - 1, 0, -1):
    if st[i] in sset and st[i - 1] != ')':
        st[i - 1:i] = ['(', st[i - 1], ')']

st = ['(', '('] + st + [')', '1']
N = len(st)
stack = []
for i in range(N):
    if st[i] == '(':
        stack.append(0)
    elif st[i] == ')':
        if stack:
            if st[i+1] in sset:
                m = int(st[i + 1]) * stack.pop()
            else:
                m = stack.pop()
        if stack:
            stack[-1] += m
    elif st[i] in sset:
        continue
    elif stack:
        stack[-1] += dic.get(st[i])


print(stack[0])