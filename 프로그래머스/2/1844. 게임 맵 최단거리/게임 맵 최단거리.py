def solution(maps):
    maxLoc = [[0, 0]]
    m = len(maps)
    n = len(maps[0])
    move = [(-1, 0), (1, 0), (0, -1), (0, 1)]   # 상하좌우
    cnt = 0
    while len(maxLoc) > 0:
        _maxLoc = []
        for x, y in maxLoc:
            for i, j in move:
                _x, _y = x + i, y + j
                if 0 <= _x < m and 0 <= _y < n and maps[_x][_y] == 1 and (_x != 0 or _y != 0):
                    maps[_x][_y] = maps[x][y] + 1
                    _maxLoc.append([_x, _y])
                    if _x == m-1 and _y == n-1:
                        return maps[_x][_y]
        maxLoc = _maxLoc  
    return -1