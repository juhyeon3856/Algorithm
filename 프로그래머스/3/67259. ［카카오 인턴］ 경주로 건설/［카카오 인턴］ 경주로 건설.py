def solution(board):
    #key는 지불한 금액, value는 key만큼 지불 수 갈수 있는곳 인덱스(i, j)와 수평(Horizontal)수직(Vertical) 중 어디서 왔는지(k)로 [i, j, k]값을 가짐
    visited = {100:[]}
    inputValue = {}
    board[0][0] = 1
    if board[0][1] == 0:
        board[0][1] = 100
        visited[100].append([0, 1, "H"])
        inputValue[(0, 1, "H")] = True
    if board[1][0] == 0:
        board[1][0] = 100
        visited[100].append([1, 0, "V"])
        inputValue[(1, 0, "V")] = True
    n = len(board)
    pay = 100
    while True:
        if pay - 100 in visited:
            for i, j, k in visited[pay-100]:
                if k == "H":
                    if j+1 < n and board[i][j+1] == 0 and (i, j+1, "H") not in inputValue:
                        visited[pay].append([i, j+1, "H"])
                        inputValue[(i, j+1, "H")] = True
                        if i == n-1 and j+1 == n-1:
                            return pay
                    if j-1 >= 0 and board[i][j-1] == 0 and (i, j-1, "H") not in inputValue:
                        visited[pay].append([i, j-1, "H"])
                        inputValue[(i, j-1, "H")] = True
                elif k == "V":
                    if i+1 < n and board[i+1][j] == 0 and (i+1, j, "V") not in inputValue:
                        visited[pay].append([i+1, j, "V"])
                        inputValue[(i+1, j, "V")] = True
                        if i+1 == n-1 and j == n-1:
                            return pay
                    if i-1 >= 0 and board[i-1][j] == 0 and (i-1, j, "V") not in inputValue:
                        visited[pay].append([i-1, j, "V"])
                        inputValue[(i-1, j, "V")] = True
        if pay - 600 in visited:
            for i, j, k in visited[pay-600]:
                if k == "H":
                    if i+1 < n and board[i+1][j] == 0 and (i+1, j, "V") not in inputValue:
                        visited[pay].append([i+1, j, "V"])
                        inputValue[(i+1, j, "V")] = True
                        if i+1 == n-1 and j == n-1:
                            return pay
                    if i-1 >= 0 and board[i-1][j] == 0 and (i-1, j, "V") not in inputValue:
                        visited[pay].append([i-1, j, "V"])
                        inputValue[(i-1, j, "V")] = True
                elif k == "V":
                    if j+1 < n and board[i][j+1] == 0 and (i, j+1, "H") not in inputValue:
                        visited[pay].append([i, j+1, "H"])
                        inputValue[(i, j+1, "H")] = True
                        if i == n-1 and j+1 == n-1:
                            return pay
                    if j-1 >= 0 and board[i][j-1] == 0 and (i, j-1, "H") not in inputValue:
                        visited[pay].append([i, j-1, "H"])
                        inputValue[(i, j-1, "H")] = True
        pay += 100
        visited[pay] = []