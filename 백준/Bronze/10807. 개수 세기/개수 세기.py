N = int(input())
cnt = [0] * 201  # 원래 수 +100 == 인덱스


def num_count(num):
    num = int(num)
    cnt[num + 100] += 1


list(map(num_count, input().split()))
print(cnt[int(input()) + 100])