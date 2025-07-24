# 조건
# 과를 마치고 돌아온 난쟁이가 일곱 명이 아닌 아홉 명
# 일곱 난쟁이의 키의 합이 100
# 아홉 난쟁이의 키는 모두 다르며
# 일곱 난쟁이의 키를 오름차순으로 출력한다

# 아이디어
# 9명 중 7명을 택해서 합이 100인지 보기
# 근데 꼭 7명을 봐야할까? 합에서 2명을 뺀 값이 100이 되면 되지 않을까?
# 7명을 택하면
# 1. for문을 돌리는 경우 7중 for문
# 2. 재귀로 하면 depth가 7
# 2명을 택하면
# 1. for문으로 하면 2중 for문
# 2. 재귀로 하면 depth가 2

# 2명을 택하면 택한 100에서 빼야 하는 연산이 있음
# 하지만 7명을 택하면 7번 덧셈을 계속 해야함
# 9C7과 9C2는 같은 값이므로 경우의 수는 다르지않음
# 다만 2명을 택하면 마지막에 난쟁이가 아닌 사람을 출력할 떄 if문으로 검사해야함(난쟁이는 키가 다르므로 문제없음)
# --> 그래서 난쟁이가 아닌 두명만 선택하는 코드로 가보자

N = 9
lst = sorted([int(input()) for _ in range(9)]) # 오름차순으로 정렬하여 정답을 출력하기 위해 먼저 sort

def printAnswer(num1, num2):
    for i in range(N):
        # num1, num2 는 출력 안함
        if i == num1 or i == num2:
            continue
        print(lst[i])

# 이중 for문 break하는 방법 몰라서 함수 만들어서 break대신 return해버리려고 함
def sol():
    sm2 = sum(lst) - 100    # 난쟁이가 아닌 두명의 키 합
    for i in range(9):
        for j in range(i+1, 9):
            if lst[i] + lst[j] == sm2:
                # 정답 출력하는 함수(코드 가독성을 위해서 함수로 분리)
                printAnswer(i, j)
                return

sol()