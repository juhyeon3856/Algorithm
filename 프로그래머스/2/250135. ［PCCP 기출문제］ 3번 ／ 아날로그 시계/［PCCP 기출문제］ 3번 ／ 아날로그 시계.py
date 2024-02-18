def solution(h1, m1, s1, h2, m2, s2):
    srt = h1 * 60 * 60 + m1 * 60 + s1
    end = h2 * 60 * 60 + m2 * 60 + s2
    answer = 0
    for i in range(srt,end):
        s = (6*i) % 360         #초침 각도
        m = ((1/10)*i) % 360    #분침 각도
        h = ((1/120)*i) % 360   #시침 각도

        if int(s)//6 == int(m)//6:  #초침과 분침이 있는 칸이 같으면
            answer += 1
        if int(s)//6 == int(h)//6:  #초침과 시침이 있는 칸이 같으면
            answer += 1
        if int(h)//6 == 0 and int(m)//6 == 0 and int(s)//6 == 0: 
            answer -= 1
        if int(h)//6 == 59 and int(m)//6 == 59 and int(s)//6 == 59: 
            answer -= 1
        if int(s)//6 == 59 and int(m)//6 == 59:
            answer -= 1
    if m2 == 0 and s2 == 0:
        answer += 1
    return answer
