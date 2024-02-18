def solution(arr):
    for i in range(len(arr)-1):
        arr[i+1] = arr[i]*arr[i+1] / gcd(arr[i],arr[i+1])
    return arr[-1]

def gcd(a,b):
    while b>0:
        a , b = b , a%b
    return a
    