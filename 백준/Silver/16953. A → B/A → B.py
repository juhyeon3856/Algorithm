# 시작시간 : 9시 28분
# 끝난 시간 : 9시 39분



S, E = map(int, input().split())
ans = 0

while True:
    if E == S:
        ans += 1
        break
    if E < S:
        ans = -1
        break
    elif E % 2 == 0:  #짝수면 2로 나눔
        E //= 2
        ans += 1
    elif E%10 == 1:     # 오른쪽에 1 추가해서 만든 수면
        E //= 10
        ans += 1
    else:               # 나머지 홀수는 불가능
        ans = -1
        break
print(ans)