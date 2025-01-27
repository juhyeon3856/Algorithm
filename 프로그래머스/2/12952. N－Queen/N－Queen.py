def solution(n):
    def func(board, k):
        if k == n:
            return 1
        count = 0
        for i in range(n):
            if board[k][i] == 0:
                updateBoard(board, k, i, 1)
                count += func(board, k+1)
                updateBoard(board, k, i, -1)
        return count

    def updateBoard(board, x, y, delta):
        for i in range(n):
            if x <= x-y+i < n:
                board[x-y+i][i] += delta
            if x<= x+y-i < n:
                board[x+y-i][i] += delta
            board[x][i] += delta
            board[i][y] += delta
    
    return func([[0 for i in range(n)] for i in range(n)], 0)