def solution(park, routes):
    # 시작점 잡기
    for i in range(len(park)):
        if "S" in park[i]:
            y=i
            break
    x = park[y].index("S")
    
    # 방향 이동
    for r in routes:
        q=int(r[2])
        if r[0] == "E" and 0 <= x+q < len(park[0]):
            for i in range(1,q+1):
                if park[y][x+i] == "X":
                    x=x-q
                    break
            x=x+q
        
        elif r[0] == "W" and 0 <= x-q < len(park[0]):
            for i in range(1,q+1):
                if park[y][x-i] == "X":
                    x=x+q
                    break
            x=x-q

        elif r[0] == "S" and 0 <= y+q < len(park):
            for i in range(1,q+1):
                if park[y+i][x] == "X":
                    y=y-q
                    break
            y=y+q
    
        elif r[0] == "N" and 0 <= y-q < len(park):
            for i in range(1,q+1):
                if park[y-i][x] == "X":
                    y=y+q
                    break
            y=y-q
            
    return [y,x]