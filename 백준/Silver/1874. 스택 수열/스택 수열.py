# 조건
# 1부터 N까지 수를 push, pop을 통해 주어진 수열로 만드는 과정을 출력하라.

# 입력
N = int(input())

lst = [int(input()) for _ in range(N)]
stack = []
ans = []
visited = [False] * (N + 1)  # stack에 이미 들어가 있는지 확인
num = 1
i = 0
while i < N:
    if num == lst[i]:
        ans.append("+")
        ans.append("-")
        i += 1
        num += 1
    elif stack and stack[-1] == lst[i]:
        ans.append("-")
        stack.pop(-1)
        i += 1
    elif visited[lst[i]]:  # stack에 이미 있음 == 불가능
        print("NO")
        break
    else:
        visited[num] = True
        ans.append("+")
        stack.append(num)
        num += 1

else:
    print(*ans, sep="\n")