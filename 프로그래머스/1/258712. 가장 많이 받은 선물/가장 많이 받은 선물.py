def solution(friends, gifts):
    person = {}
    level = {}
    for i in range(len(friends)):
        person[friends[i]] = i
        level[friends[i]] = 0
    give = [[0]*len(friends) for _ in range(len(friends))]
    for p in gifts:
        p1, p2 = p.split()
        give[person[p1]][person[p2]] += 1
        level[p1] += 1
        level[p2] -= 1
    who = 'umm'
    answer = 0
    for i in range(len(friends)):
        cnt = 0
        for j in range(len(friends)):
            if give[i][j] > give[j][i]:
                cnt += 1
            elif give[i][j] == give[j][i] and level[friends[i]] > level[friends[j]]:
                cnt += 1
        if answer < cnt:
            answer = cnt
    return answer