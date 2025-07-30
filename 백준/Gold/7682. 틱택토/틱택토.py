# 아이디어
# X의 개수 x / O의 개수 o / 3개 연속인 개수 final
# x < o 이면 invalid
# valid인 경우!
# final == 0이면 x + o = 9
# final == 1이면
# x가 최종인 경우 : x > o
# o가 최종인 경우 : x == 0
# final == 2이면
# 최종을 만든 개수가 5개 이면

# x, o개수 세는 함수
def cnt(flst):
    fx, fo = 0, 0
    for v in flst:
        if v == 'X': fx += 1
        if v == 'O': fo += 1
    return [fx, fo]


# 3개 연속인 개수 세는 함수
def cnt_final(flst):
    result = 0
    result_arr = [['.'] * 3 for _ in range(3)]

    # 가로가 같은지 확인
    for i in range(3):
        for j in range(1, 3):
            if flst[i * 3 + j] == '.' or flst[i * 3 + j] != flst[i * 3 + j - 1]:  # 다른 값이 있으면
                break
        else:
            result += 1
            for j in range(3):
                result_arr[i][j] = flst[i * 3 + j]  # 빙고 만드는 배열 반영

    # 세로가 같은지 확인
    for i in range(3):
        for j in range(1, 3):
            if flst[j * 3 + i] == '.' or flst[(j - 1) * 3 + i] != flst[j * 3 + i]:  # 다른 값 있으면
                break
        else:
            result += 1
            for j in range(3):
                result_arr[j][i] = flst[j * 3 + i]  # 빙고 만드는 배열 저장

    # 대각선 아래 같은지 확인
    for i in range(1, 3):
        if  flst[i * 3 + i] == '.' or flst[(i - 1) * 3 + (i - 1)] != flst[i * 3 + i]:  # 다른 값 있으면
            break
    else:
        result += 1
        for i in range(3):
            result_arr[i][i] = flst[i * 3 + i]

    # 대각선 위 같은지 확인
    for i in range(1, 3):
        if flst[i * 3 + 3 - i - 1] == '.' or flst[(i - 1) * 3 + 3 - i] != flst[i * 3 + 3 - i - 1]:  # 다른 값 있으면
            break
    else:
        result += 1
        for i in range(3):
            result_arr[i][3 - i - 1] = flst[i * 3 + 3 - i - 1]
    return [result, result_arr]


def find_winner(farr):
    for i in range(3):
        for j in range(3):
            if farr[i][j] != '.':
                return farr[i][j]


def cnt_winner(farr):
    result = 0
    for i in range(3):
        for j in range(3):
            if farr[i][j] != '.':
                result += 1
    return result


while True:
    lst = input()
    if lst == 'end': break
    x, o = cnt(lst)  # x, o 개수 세기
    ans = 'invalid'
    if x == o or x == o+1:
        final_cnt, final_arr = cnt_final(lst)  # 3개 연속인 개수 세기 , 결과 받기
        if final_cnt == 0 and x + o == 9:
            ans = 'valid'
        if final_cnt == 1:
            if x > o and find_winner(final_arr) == 'X':
                ans = 'valid'
            if x == o and find_winner(final_arr) == 'O':
                ans = 'valid'
        if final_cnt == 2:
            if cnt_winner(final_arr) == 5:
                ans = 'valid'
    print(ans)
