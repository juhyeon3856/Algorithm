# 공유기 설치
# 시작시간 : 7시 59분
# 끝난시간 : 8시 33분
# 소요시간 : 34분
# 아이디어 : 이분탐색 (x : 집 사이 거리)
# 목표 : 가장 인접한 두 공유기 사이의 거리를 최대


def main():
    # min, 공유기 사이 거리 최대
    return find_dist(0, (home[-1] - home[0]) // (C - 1) + 1)


def find_dist(s, e):
    result = 0
    while s < e:
        mid = (s + e) // 2
        if use(mid):  # 해당 길이로 설치 가능하면
            result = mid  # 정답 후보에 넣고
            s = mid + 1  # 더 큰거 찾아보기 위해서
        else:  # 설치 불가능하면
            e = mid  # 길이가 더 짧아져야 함
    return result


# 해당 거리로 공유기가 설치 가능한지 체크
def use(llen):
    ch = home[0]  # 젤 앞에 집에 설치
    max_home = home[-1]  # 젤 마지막 집 위치
    for _ in range(1, C):  # 나머지 C - 1개도 설치
        nh = ch + llen  # 다음 집이 될 수 있는 최소 위치
        if nh > max_home:  # 다음번에 설치 할 곳이 이미 마지막 집보다 크면
            return False  # 설치할 곳이 없으니 해당 길이로 설치 불가
        ch = find_nxt(nh)  # 설치할 다음 집
        if ch < 0:  # 다음집이 없으면
            print("!!!!!!!!!!!!!!!!!!!!!!")  # 이럴수없음...ㅜㅠ
    return True  # 설치 가능


# 해당 거리보다 크거나 같은 다음 집 찾기
def find_nxt(num):
    s, e = 0, N
    result = -1  # 다음 값 항상 있음
    while s < e:
        mid = (s + e) // 2
        if home[mid] >= num:  # 정답 후보이면
            result = home[mid]  # 정답 갱신
            e = mid  # 더 작은값 찾으러 가기
        else:  # 더 커야하면
            s = mid + 1
    return result


# 입력 및 전처리
N, C = map(int, input().split())
home = [int(input()) for _ in range(N)]
home.sort()
print(main())