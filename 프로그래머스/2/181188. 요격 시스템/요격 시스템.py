def solution(target):  
    answer = 0
    target.sort(key=lambda x: x[1])
    while target:
        num = 0
        answer += 1
        for s,_ in target:
            if target[0][1] > s:
                num += 1
            else:
                break
        del target[:num]
    return answer