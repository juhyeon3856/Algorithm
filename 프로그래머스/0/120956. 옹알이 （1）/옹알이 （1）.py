def solution(babbling):
    cs = ["aya", "ye", "woo", "ma"]
    answer = 0
    for b in babbling:
        if b[:2] in cs:
            babbling.append(b[2:])
        elif b[:3] in cs:
            babbling.append(b[3:])
        elif b == "":
            answer += 1
    return answer