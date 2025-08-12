# 입력
N, K = map(int, input().split())  # 포도주 수, 산들이 주량
T = list(map(int, input().split()))  # 포도주 맛

# 전처리
T.sort()

# 로직 및 정답 출력
# 아이디어 : 큰수부터 (K+1)//2개 더하고, 작은 수 부터 K//2개 뻄
print(sum(T[-((K + 1) // 2):]) - sum(T[:(K - 1) // 2]))