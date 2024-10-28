def solution(s):
    dic = {}
    answer = []
    for i in range(len(s)):
        if s[i] in dic:
            answer.append(i-dic[s[i]])
            dic[s[i]] = i
        else:
            dic[s[i]] = i
            answer.append(-1)
    return answer