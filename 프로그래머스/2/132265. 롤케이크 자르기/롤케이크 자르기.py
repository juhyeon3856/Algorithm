def solution(topping):
    answer = 0
    left = {}
    right = {}
    for t in topping:
        right[t] = right.get(t, 0) + 1
    left_uni = 0
    right_uni = len(right)
    for t in topping:
        if t not in left:
            left_uni += 1
        left[t] = left.get(t, 0) + 1
        right[t] -= 1
        if right[t] == 0:
            right_uni -= 1
        if left_uni == right_uni:
            answer += 1
    return answer