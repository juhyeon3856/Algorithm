# import sys
# input = sys.stdin.readline

for _ in range(4):
    x1, y1, p1, q1, x2, y2, p2, q2 = map(int, input().split())
    # d의 경우
    # 1. p < x인 경우가 있으면
    # 2. q < y인 경우가 있으면
    if x1 > p2 or x2 > p1:
        print("d")
    elif y1 > q2 or y2 > q1:
        print("d")
    # c의 경우
    # p==x인데 q==y이면
    elif x1 == p2 and y1 == q2:
        print("c")
    elif x1 == p2 and y2 == q1:
        print("c")
    elif x2 == p1 and y2 == q1:
        print("c")
    elif x2 == p1 and y1 == q2:
        print("c")
    # b의 경우
    # p==x인데 x가 x와 p사이에 있으면
    # q==y인데 y가 y와 q사이에 있으면
    elif x1 == p2:
        print("b")
    elif x2 == p1:
        print("b")
    elif y1 == q2:
        print("b")
    elif y2 == q1:
        print("b")
    # a는 나머지
    else:
        print("a")