def solution(board, h, w):
    dh = [1,0,-1,0]
    dw = [0,1,0,-1]
    answer = 0
    for i in range(4):
        new_h = h + dh[i]
        new_w = w + dw[i]
        if 0 <= new_h < len(board) and 0<= new_w < len(board[0]) and board[new_h][new_w]==board[h][w]:
                answer += 1
    return answer