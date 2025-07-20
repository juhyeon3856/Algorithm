import sys

input = sys.stdin.readline
N = 10
data = [input() for _ in range(N)]
dr = [0, 1, 1, -1]
dc = [1, 0, 1, 1]
answer = [0]

def check(r, c):
    return r >= 0 and r < N and c >= 0 and c < N

# def isStart(cr, cc, dd):
#     nr = cr + dr[dd] * -1
#     nc = cc + dc[dd] * -1
#     if not check(nr, nc): return True
#     if data[nr][nc] == 'X': return False
#     return True

def isWin(cr, cc, dd):
    count = 0
    for i in range(5):
        nr = cr + dr[dd] * i
        nc = cc + dc[dd] * i
        if not check(nr, nc): return False
        if data[nr][nc] == 'O': return False
        if data[nr][nc] == 'X': count += 1
    if count == 4: return True
    return False

def main():
    for i in range(N):
        for j in range(N):
            for d in range(4):
                # if not isStart(i, j, d): continue
                if isWin(i, j, d): 
                    answer[0] = 1
                    return

main()
print(answer[0])