def solution(arr):
    return quater(arr, len(arr), [0, 0])

def quater(arr, size, result):
    S = sum(sum(arr, []))
    if S == 0:
        result[0] += 1
    elif S == size * size:
        result[1] += 1
    else:
        s = size//2
        quater([arr[i][:s] for i in range(s)], s, result)
        quater([arr[i][s:] for i in range(s)], s, result)
        quater([arr[i][:s] for i in range(s, 2*s)], s, result)
        quater([arr[i][s:] for i in range(s, 2*s)], s, result)
    return result
