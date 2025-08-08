N, a, b = map(int, input().split())
print(len(bin((a-1) ^ (b-1)))-2)