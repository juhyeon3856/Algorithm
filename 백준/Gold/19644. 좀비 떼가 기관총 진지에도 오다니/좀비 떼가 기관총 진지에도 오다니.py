from collections import deque  # 폭탄 인덱스 순서대로 넣으니 선입선출

L = int(input())
ML, MK = map(int, input().split())
C = int(input())
endC = deque([])  # 폭탄 끝나는 인덱스 -> 끝나면 sub값 하나 줄여줌
add = 0  # 공격 받은 개수 *  MK, max = ML * MK
sub = 0  # 폭탄으로인해 공격 놓친 개수 * MK, max = ML * MK
Z = [int(input()) for _ in range(L)]

# 입력 완료! 풀이 시작
ans = "YES"  # 초기값 YES, 죽으면 NO로 반영
for i in range(L):
    if endC and endC[0] == i:  # 폭탄 던진 적이 있고, 폭탄 영향있는 마지막 인덱스면
        sub -= MK  # 폭탄 영향 하나 줄여줌
        endC.popleft()  # 폭탄 영향 하나 빼줌
    if Z[i] > min(MK * ML, add + MK) - sub:  # 이번 공격으로 못죽이면
        if C > 0:  # 폭탄 남았으면
            C -= 1
            sub += MK
            endC.append(i + ML)
        else:  # 폭탄도 없으면
            ans = "NO"
            break
    add = min(ML * MK, add + MK)

print(ans)