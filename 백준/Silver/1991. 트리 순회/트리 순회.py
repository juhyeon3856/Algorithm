N = int(input())

left = dict()
right = dict()


def preord(pre):  # 나 > 왼 > 오
    if pre == '.':  # 더 이상 없으면
        return  # 종료
    print(pre, end="")  # 나
    preord(left.get(pre))  # 왼
    preord(right.get(pre))  # 오


def inord(pre):  # 왼 > 나 > 오
    if pre == '.':  # 더 이상 없으면
        return  # 종료
    inord(left.get(pre))  # 왼
    print(pre, end="")  # 나
    inord(right.get(pre))  # 오


def postord(pre):  # 왼 > 오 > 나
    if pre == '.':  # 더 이상 없으면
        return  # 종료
    postord(left.get(pre))  # 왼
    postord(right.get(pre))  # 오
    print(pre, end="")  # 나


for _ in range(N):
    c, l, r = input().split()
    left[c] = l
    right[c] = r

# 입력 완료! 로직 시작
preord('A')  # 전위 순회
print()
inord('A')  # 중위 순회
print()
postord('A')  # 후위 순회
