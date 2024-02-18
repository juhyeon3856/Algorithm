from itertools import permutations


def solution(k, dungeons):
    p = permutations(range(len(dungeons)), len(dungeons))
    answer = 0
    for l in p:
        kt = k
        c = 0
        for i in range(len(l)):
            if kt >= dungeons[l[i]][0]:
                c+=1
                kt = kt - dungeons[l[i]][1]
            else:
                break
        if c > answer:
            answer = c
    return answer




def solution1(k, dungeons):
    answer = 0
    while(len(dungeons)>0):
        dungeons, k = CNT(k,dungeons)
        answer += 1
    return answer
        
        
def CNT(k,dng1):
    R = []
    kr = k
    for i in range(len(dng1)):
        l1 = dng1[i]
        dng = dng1[:i][:] + dng1[i+1:][:]
        c = []
        for l2 in dng:
            if l2[0] <= k-l1[1]:
                c.append(l2) 
        if len(R) < len(c):
            R = c
            kr = k - l1[1]
        elif len(R) == len(c) and kr < k - l1[1]:
            R = c
            kr = k - l1[1]
    return R , kr