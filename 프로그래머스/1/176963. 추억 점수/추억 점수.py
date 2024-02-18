def solution(name, yearning, photo):
    n = {key : i for key,i in zip(name,yearning)}
    answer = [0] * len(photo)
    for i in range(len(photo)):
        while len(photo[i])>0:
            people = photo[i].pop()
            if n.get(people) is not None:
                answer[i]=answer[i]+n[people]
    return answer