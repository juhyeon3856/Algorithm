def solution(n,a,b):
    a2 = bin(a-1)[2:]
    b2 = bin(b-1)[2:]
    answer = 0
    if len(a2) == len(b2):
        for i in range(len(a2)):
            if a2[i] != b2[i]:
                answer = len(a2) - i
                break
    else:
        answer = max(len(a2),len(b2))
            
            
    return answer