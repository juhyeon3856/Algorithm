def solution(cards):
    Len=[]
    for i in range(len(cards)):
        if cards[i] != 0:
            l=0
            a = cards[i] -1
            cards[i] = 0
            while a >= 0 : 
                l += 1
                b=cards[a]
                cards[a] = 0
                a=b-1
            Len.append(l)
    Len.sort(reverse = True)
    if len(Len)==1:
        answer = 0
    else : 
        answer = Len[0]*Len[1]
    
    return answer