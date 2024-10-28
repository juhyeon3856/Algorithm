def solution(n, lost, reserve):
    lost.sort()
    _lost = lost[:]
    for lostNum in lost:
        if lostNum in reserve:
            _lost.remove(lostNum)
            reserve.remove(lostNum)
    lost = _lost[:]
    for lostNum in lost:
        if lostNum - 1 in reserve:
            _lost.remove(lostNum)
            reserve.remove(lostNum-1)
        elif lostNum + 1 in reserve:
            _lost.remove(lostNum)
            reserve.remove(lostNum + 1)
    answer = n - len(_lost)
    return answer