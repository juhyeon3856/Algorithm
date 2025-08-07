# 퀵정렬 : 인덱스 사용
N = int(input())
lst = [int(input()) for _ in range(N)]


# lst의 i번째와 j번째 교환(함수 안만들어도 될듯 -> 그냥 가독성)
def swap(i, j):
    lst[i], lst[j] = lst[j], lst[i]


def qsort(si, ei):  # 시작, 끝 인덱스
    if si >= ei: return  # 길이가 1이면 종료
    st, s, e = si, si + 1, ei

    stn = lst[st]
    while s < e:
        while s < ei and lst[s] <= stn: s += 1  # 작은 수 넘어감 ->  이거 끝나면 s는 stn보다 큰 것 가리킴
        while e > si and lst[e] > stn: e -= 1  # 큰수 넘어감 ->  이거 끝나면 e는 stn보다 작은 것 가리킴
        if s < ei and e > si + 1 and s < e:
            swap(s, e)

    # st위치 조정 -> e에 st보내기
    if lst[st] < lst[e]:
        e = e-1
    swap(st, e)

    # 0부터 e-1까지 다시 qsort
    qsort(si, e - 1)
    # e+1부터 ei까지 다시 qsort
    qsort(e + 1, ei)


qsort(0, N - 1)
print(*lst, sep="\n")