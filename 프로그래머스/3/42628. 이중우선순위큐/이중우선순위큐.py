def solution(operations):
    answer = []
    for s in operations:
        if s[0] == "I":
            answer = plusSort(answer, int(s[2:]))
        elif int(s[2:]) == 1:
            answer = answer[:-1]
        else:
            answer = answer[1:]
    if len(answer) == 0:
        answer = [0, 0]
    else:
        answer = [answer[-1], answer[0]]
    return answer

#같아진거 다음에 들어가면 됌(sort 알고리즘)
def plusSort(l, a):
    start = 0
    end = len(l)
    check = (start + end) //2 
    while end > start:
        if a == l[check]:
            break
        elif a > l[check]:
            start = check + 1
            check = (start + end) //2 
        else:
            end = check
            check = (start + end) //2 
    return l[:check] + [a] + l[check:]