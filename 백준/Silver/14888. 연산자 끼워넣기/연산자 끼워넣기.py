# 시작시간 3시 38분
# 제출시간 3시 56분
# 소요시간 18분 + 1분
# 시도횟수 2회(max초기값 처리)
# 나눗셈 => 음수일 경우 -(-num1 / num2)


# 입력 완료 로직 시작
def perm(depth):
    if depth == N:  # 다 골랐으면
        cc = select_clac()  # select_opers순서대로 계산
        ans[0] = max(ans[0], cc)  # mx갱신
        ans[1] = min(ans[1], cc)  # mn갱신
        return
    for i in range(4):
        if opers[i] == 0: # 남은거 없으면 패스
            continue
        select_opers[depth] = i
        opers[i] -= 1  # 사용했으니 하나 줄이기
        perm(depth + 1)  # 재귀 들어갔다 나오면
        opers[i] += 1  # 원상복구


# num와 select_oper을 연산한 값 리턴
def select_clac():
    result = nums[0]
    for i in range(1, N):
        result = clac(result, nums[i], select_opers[i])
    return result


# 사칙연산 결과값 리턴
def clac(num1, num2, op):
    if op == 0:
        return num1 + num2
    elif op == 1:
        return num1 - num2
    elif op == 2:
        return num1 * num2
    elif op == 3:  # 음수 나눗셈 처리
        return num1 // num2 if num1 >= 0 else -(-num1 // num2)


N = int(input())
nums = list(map(int, input().split()))
opers = list(map(int, input().split()))  # 4개 / visited처럼 사용
select_opers = [0] * N  # 1부터 계산식 넣음. 즉, 계산은 num[i] oper[i+1] num[i+1]
ans = [-20000000000, 20000000000]  # 최대, 최소

perm(1)
print(*ans, sep="\n")