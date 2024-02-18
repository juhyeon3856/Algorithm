def solution1(s):
    answer = True
    out=[]
    s_copy = s
    if s.count("(") == s.count(")"):
        for e in s:
            if e == '(':
                out.append(s_copy[0])
                s_copy = s_copy[1:]
            elif len(out) > 0:
                out.pop()
                s_copy = s_copy[1:]
            elif len(out) == 0:
                answer = False
                break
    else : 
        answer = False
            
    return answer


def solution(s):
    cnt = 0
    answer = True
    if s.count("(") == s.count(")"):
        for e in s:
            if e == '(':
                cnt+=1
            else:
                cnt-=1
            if cnt < 0:
                answer = False
                break
    else : 
        answer = False
            
    return answer