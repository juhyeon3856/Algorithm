def solution(board, moves):
    answer = 0
    basket = [-1]
    for num in moves:
        for i in range(len(board)):
            if board[i][num-1] == basket[-1]:
                basket.pop()
                board[i][num-1] = 0
                answer += 2
                break
            elif board[i][num-1] > 0:
                basket.append(board[i][num-1])
                board[i][num-1] = 0
                break
    return answer