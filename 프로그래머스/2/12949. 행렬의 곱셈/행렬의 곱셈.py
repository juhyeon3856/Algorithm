def solution(arr1, arr2):
    answer = zeros(len(arr1), len(arr2[0]))
    for i in range(len(arr1)):
        for j in range(len(arr2[0])):
            l1 = arr1[i]
            l2 = []
            for k in range(len(arr2)):
                l2.append(arr2[k][j])
            answer[i][j] = dotproduct(l1, l2)
    return answer

def dotproduct(l1, l2):
    sum = 0
    for i in range(len(l1)):
        sum = sum + l1[i]*l2[i]
    return sum

def zeros(len1, len2):
    zero = []
    for i in range(len1):
        zero.append([0]*len2)
    return zero