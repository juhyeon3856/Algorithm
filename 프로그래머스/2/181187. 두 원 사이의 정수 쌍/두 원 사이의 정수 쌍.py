def solution(r1, r2):
    return cnt(r2) - cnt(r1) + pytha(r1)

def cnt(r):
    num = 1 + 4*r
    for a in range(1,r):
        num = num + int((r**2 - a**2)**0.5)*4
    return num

def pytha(r):
    num = 0
    for a in range(1,int(r/(2**0.5))):
        b = (r**2 - a**2)**0.5
        if int(b) == b:
            num+=1
    return 8*num+4