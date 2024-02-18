def solution1(progresses, speeds):
    L = [(99-progresses[i])//speeds[i]+1 for i in range(len(speeds))]
    answer = []
    while L:
        a=0
        S = [l-L[0] for l in L]
        for i in range(len(L)):
            if S[i] <= 0:
                L.pop(0)
                a+=1
            else: 
                break
        answer.append(a)
    return answer


def solution(progresses,speeds):
    L = [(99-progresses[i])//speeds[i]+1 for i in range(len(speeds))]
    A = [0]*(len(L)+1)
    a = L[0]
    n=0
    for i in range(len(L)):
        if L[i] <= a:
            A[n] += 1
        else:
            a=L[i]
            n+=1
            A[n] += 1
    return A[:A.index(0)]