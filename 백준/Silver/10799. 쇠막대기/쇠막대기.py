# 시작시간 8시 22분

# 아이디어
# stack사용

st = input()
stack = []
ans = 0

i = 0
while i < len(st):
    if st[i] == "(":
        if st[i + 1] == ")":  # 레이저
            ans += len(stack)
            i += 1  # 닫는 괄호 지나가기
        else:  # 쇠막대
            stack.append('(')
    else:  # 쇠막대 나가는거
        ans += 1
        stack.pop()
    i += 1
print(ans)