st = input()
print(int(st[:len(st) // 2] == st[:int(len(st) / 2 - 0.5):-1]))