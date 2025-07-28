# 조건
# 왼쪽에 자기보다 큰 수 중 가장 오른쪽에 있는 수를 구하기

# 아이디어
# stack에 넣었다가 큰 수 만나면 계속 빼기

N = int(input())
lst = list(map(int, input().split()))[::-1]
stack = []  # index를 넣음
ans = [0] * N

for i in range(N):
    while stack and lst[stack[-1]] < lst[i]:
        ans[stack.pop(-1)] = N - i
    stack.append(i)

print(*ans[::-1])