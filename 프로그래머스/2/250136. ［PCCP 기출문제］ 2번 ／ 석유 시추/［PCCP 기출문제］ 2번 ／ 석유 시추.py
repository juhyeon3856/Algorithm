def solution(land):
    from collections import deque
    n,m = len(land), len(land[0])
#    dist = [[0]*m for _ in range(n)]
    dx = [1,0,-1,0]
    dy = [0,1,0,-1]
    a=2
    num=[0,0]
    
    
    for i in range(n):
        for j in range(m):
            if land[i][j]==1:
                land[i][j] = a 
                num.append(1)
                queue = deque([(j,i)])
                while queue:
                    x,y = queue.popleft()
                    for k in range(4):
                        x_new = x + dx[k]
                        y_new = y + dy[k]
                        if 0 <= x_new < m and 0 <= y_new < n and land[y_new][x_new] == 1:
                            queue.append((x_new, y_new))
                            land[y_new][x_new] = a
                            num[a]+=1
                a+=1
                            

    answer = 0
    for i in range(m):
        sum = 0
        s={0}
        for j in range(n):
            s.add(land[j][i])
        s=s-{0}
        for k in range(len(s)):
            sum = sum+num[s.pop()]
        if sum > answer:
            answer = sum
    
    
    return answer