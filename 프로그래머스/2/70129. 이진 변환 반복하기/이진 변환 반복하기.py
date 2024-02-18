def solution(s):
    answer = [0,0]
    while len(s) > 1 :
        cnt_zero = s.count('0')
        answer[0] += 1
        answer[1] += cnt_zero
        s = bin(int(len(s)-cnt_zero))[2:]
        print(s)
    return answer