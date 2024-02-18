def solution(n, words):
    for i in range(len(words)):
        if words[i] in words[:i]:
            answer = [((i)%n)+1,((i)//n)+1]
            break
        elif i==len(words)-1:
            answer = [0,0]
            break
        elif words[i+1][0] != words[i][-1]:
            answer = [((i+1)%n)+1,((i+1)//n)+1]
            break
    return answer