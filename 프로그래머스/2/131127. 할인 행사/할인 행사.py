def solution(want, number, discount):
    answer = 0
    wantNumber = []
    for w, n in zip(want, number):
        for j in range(n):
            wantNumber.append(w)
    wantNumber.sort()
    for i in range(len(discount) - 9):
        dis = discount[i:i+10]
        dis.sort()
        if dis == wantNumber:
            answer += 1
    return answer