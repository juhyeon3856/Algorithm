# 아이디어 = 이분탐색 & union-find

# 이분 탐색
def search(num):
    s, e = 0, len(lst)
    result = -1  # index 저장
    while s < e:
        mid = (s + e) // 2
        if lst[mid] <= num:
            s = mid + 1
        else:
            result = mid
            e = mid
    if result == -1:  # 없으면 -1(이런 경우 없음)
        print("!!!!!!!!!!!!!!!!!!!")
    result = find(result)
    p[result] = result + 1  # 자기 바로 위
    return result


# 유니온 파인드
def find(idx):
    if idx == p[idx]:  # 아직 사용 안했으면
        return idx
    p[idx] = find(p[idx])
    return p[idx]


# 입력
N, M, K = map(int, input().split())

lst = list(map(int, input().split()))
minsu = list(map(int, input().split()))
p = [i for i in range(M + 1)]  # 처음에는 자기 자신

# 정렬
lst.sort()
ans = []

# 탐색 및 정답
for m in minsu:
    ans.append(lst[search(m)])

# 출력
print(*ans, sep="\n")