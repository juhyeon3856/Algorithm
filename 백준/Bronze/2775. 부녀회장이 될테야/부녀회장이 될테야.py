T = int(input())

def combi(n, r):
  return factorial(n, r)//factorial(r, r)

def factorial(num, count):
  result = 1
  for i in range(num-count+1, num+1):
    result *= i
  return result
  
for _ in range(T):
  k = int(input())
  n = int(input())
  print(combi(k+n, k+1)) #k층 n호