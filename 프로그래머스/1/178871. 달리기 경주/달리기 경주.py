def solution(players, callings):
    p = dict()
    d = dict()
    for i in range(len(players)):
        p[players[i]]=i+1
    for i in range(len(players)):
        d[i+1] = players[i]

    for i in callings:
        num = p[i]
        d[num] , d[num-1] = d[num-1] , d[num]
        p[d[num]] = num
        p[d[num-1]] = num -1
    answer=[d[i+1] for i in range(len(players))]
    
    return answer