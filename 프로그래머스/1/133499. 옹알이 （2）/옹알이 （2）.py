def solution(babbling):
    answer = 0
    check = True
    bef = ""
    can = ["aya", "ye", "woo", "ma"]
    while babbling:
        if (babbling[0][:2] == 'ye' or babbling[0][:2] == 'ma') and babbling[0][:2] != bef:
            bef = babbling[0][:2]
            babbling[0] = babbling[0][2:]
            check = False
        elif (babbling[0][:3] == 'aya' or babbling[0][:3] == 'woo') and babbling[0][:3] != bef:
            bef = babbling[0][:3]
            babbling[0] = babbling[0][3:]
            check = False
        else: 
            check = True
            bef = ""
        if check:
            babbling.pop(0)
        elif babbling[0] == "":
            answer += 1
            bef = ""
            babbling.pop(0)
    return answer