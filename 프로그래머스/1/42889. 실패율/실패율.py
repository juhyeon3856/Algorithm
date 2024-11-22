def solution(N, stages):
    cntByStage = []
    numOfUser = 0
    answer = []
    for i in range(N+1, 0, -1):
        cntByStage.append([i, 0])
    for s in stages:
        cntByStage[N-s+1][1] += 1
    for i in range(N+1):
        numOfUser += cntByStage[i][1]
        if numOfUser != 0:
            cntByStage[i][1] = cntByStage[i][1] / numOfUser
        else:
            cntByStage[i][1] = 0
    cntByStage = cntByStage[1:]
    cntByStage.sort(key=lambda x: x[0])
    cntByStage.sort(key=lambda x: -x[1])
    for a, _ in cntByStage:
        answer.append(a)
    return answer