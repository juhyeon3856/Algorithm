# 조건
# Ai의 오큰수는 오른쪽에 있으면서 Ai보다 큰 수 중에서 가장 왼쪽에 있는 수
# 1 ≤ N ≤ 1,000,000 /  1 ≤ Ai ≤ 1,000,000

# 아이디어
# stack에 넣었다가 큰 수 만나면 계속 빼기

N = int(input())
lst = list(map(int, input().split()))
stack = []  # index를 넣음
ans = [-1] * N

for i in range(N):
    cnt = 0
    while stack and lst[stack[-1]] < lst[i]:
        ans[stack.pop(-1)] = lst[i]
    stack.append(i)

print(*ans)