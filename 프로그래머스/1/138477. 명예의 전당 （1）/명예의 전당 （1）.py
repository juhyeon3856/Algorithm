def solution(k, score):
    answer = [min(score[:i+1]) for i in range(k)]
    memo = score[:k]
    memo.sort(reverse = True)
    for S in score[k:]:
        for i in range(k):
            if memo[i] <= S:
                memo = memo[:i] + [S] + memo[i:k-1]
                answer.append(memo[k-1])
                break
            elif i == k-1:
                answer.append(memo[k-1])
    if len(answer) > len(score):
        answer=answer[:len(score)]
    return answer