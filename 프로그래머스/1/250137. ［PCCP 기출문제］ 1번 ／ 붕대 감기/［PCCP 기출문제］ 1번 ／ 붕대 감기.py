def solution(bandage, health, attacks):
    attacks.append([attacks[len(attacks)-1][0]+1,0])
    answer = health
    for i in range(len(attacks)-1):
        answer = answer - attacks[i][1]
        if answer <= 0:
            answer = -1
            break
        answer = answer + (attacks[i+1][0]-attacks[i][0]-1)*bandage[1]
        answer = answer + ((attacks[i+1][0]-attacks[i][0]-1)//bandage[0])*bandage[2]
        if answer > health: 
            answer = health
    return answer

