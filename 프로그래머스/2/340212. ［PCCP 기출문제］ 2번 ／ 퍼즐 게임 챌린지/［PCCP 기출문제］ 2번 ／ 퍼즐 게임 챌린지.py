def solution(diffs, times, limit):
    # if(limit >= levelTime(1, diffs, times)):
    #     return 1
    start = 0
    end = max(diffs)
    while(start < end - 1):
        mid = (start + end)//2
        if(limit < levelTime(mid, diffs, times)):
            start = mid
        elif(limit > levelTime(mid, diffs, times)):
            end = mid
        else:
            return mid
    return end
            


def levelTime(level, diffs, times):
    allTime = times[0]
    for i in range(1, len(diffs)):
        allTime += solTime(diffs[i] - level, times[i-1], times[i])
    return allTime
    
    
    

def solTime(levelDiff, prevT, currT):
    if (levelDiff < 0):
        levelDiff = 0
    return levelDiff * (prevT + currT) + currT
    