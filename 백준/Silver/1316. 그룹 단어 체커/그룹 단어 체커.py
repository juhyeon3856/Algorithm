N = int(input())
count = 0

for _ in range(N):
  string = input()
  if list(string) == sorted(string, key=string.find):
    count += 1

print(count)