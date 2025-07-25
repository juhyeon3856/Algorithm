N = int(input())

data = [float(input()) for _ in range(N)]
max = 0
for s in range(N):
  mult = 1.0
  for e in range(s, N):
    mult *= data[e]
#    _max = round(mult, 3)
    max = mult if mult > max else max

print(f"{max:.3f}")