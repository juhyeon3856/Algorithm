s = input()
n = int(s)

def generation(num):
    result = num
    while(num > 0):
        result += num%10
        num //= 10
    return result

answer = 0
for i in range(n - len(s)*9, n):
    if(generation(i)==n):
        answer = i
        break;

print(answer)