# 조건
# 오른쪽에서 봤을 때 보이는 막대기 수를 출력

# 아이디어
# 뒤에서 보면서 max값 보다 큰 경우 max갱신 & ans += 1

N = int(input())

lst = [int(input()) for _ in range(N)]
mx = 0
ans = 0

for i in range(N - 1, -1, -1):
    if mx < lst[i]:
        mx = lst[i]
        ans += 1

print(ans)