
N = int(input())
lst = list(map(int, input().split())) + [0]

# [ 전략2 ]
# 하나씩 순회하면서 해당 숫자가 들어가기 위한 최대 길이를 매번 갱신


def main1():
    ans = 0
    num_end_index = [[-1, 0], [-1, 0]]

    cur_length = 0
    for i in range(N + 1):
        # 이미 선택한 num과 동일하면
        if lst[i] == num_end_index[0][0]:  # 첫번쨰 인덱스와 같으면
            cur_length += 1  # 현재 길이에 1 추가
            num_end_index[0][1] = i + 1  # 해당 숫자의 마지막 인덱스로 갱신
        elif lst[i] == num_end_index[1][0]:  # 두번쨰 인덱스와 같으면
            cur_length += 1  # 현재 길이에 1 추가
            num_end_index[1][1] = i + 1
        else:  # 이미 선택한 것에 없으면
            ans = max(ans, cur_length)  # ans 값 갱신
            # 인덱스가 작은 값을 선택
            min_index = 0 if num_end_index[0][1] < num_end_index[1][1] else 1
            cur_length = i + 1 - num_end_index[min_index][1]
            num_end_index[min_index] = [lst[i], i+1]

    print(ans)

# [ 전략1 ]
# 1부터 9까지 수 중 두개를 뽑아서 가능한 최대 길이 센다

def main2():
    ans = 0
    # num1, num2만 남았을 때 최대 길이를 센다.
    def max_length(num1, num2):
        llen = 0
        result = 0
        for n in lst:
            if n == num1 or n == num2:  # 같으면
                llen += 1               # 1씩 더하기
            else:                       # num1, num2이외 다른 수 나오면
                result = max(llen, result)  # 최댓값 업데이트
                llen = 0                    # 길이 초기화
        return result

    # 1부터 9까지의 수 중 2개를 골라 max_length를 구하고 최댓값을 갱신한다.
    for i in range(1, 10):
        for j in range(i+1, 10):
            ans = max(ans, max_length(i, j))

    print(ans)

main1()