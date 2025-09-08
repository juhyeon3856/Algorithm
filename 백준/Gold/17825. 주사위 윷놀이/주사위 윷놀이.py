# 녹화 시작 지금 8분 지남!!!!!
# 구상
# 링크드리스트와 같이 구현

# 입력
dice_lst = list(map(int, input().split()))


# 전처리
# [1] map 만들어주기
class Node:
    def __init__(self, no, score, prev, nxt_red, nxt_blue):
        self.no = no
        self.score = score
        self.prev = prev
        self.nxt_red = nxt_red
        self.nxt_blue = nxt_blue

    def __repr__(self):
        return f"no : {self.no}, score : {self.score}"
        # return f"{self.no}"


score_lst = [0]  # 시작
score_lst += [2 * i for i in range(1, 21)]  # 1부터 20번 노드, 시작부터 빨간색만 타고
score_lst += [13, 16, 19]  # 10 -> 13 -> 16 -> 19
score_lst += [22, 24]  # 22 -> 24
score_lst += [28, 27, 26]  # 26 <- 27 <- 28 <- 30
score_lst += [25, 30, 35]  # 25 -> 30 -> 35
score_lst += [0]  # 도착

node_lst = []
for i in range(33):
    node_lst.append(Node(i, score_lst[i], None, None, None))


def connect_red(conn_no):
    for i in range(1, len(conn_no)):
        nxt, prv = conn_no[i], conn_no[i - 1]
        node_lst[nxt].prev = node_lst[prv]
        node_lst[prv].nxt_red = node_lst[nxt]


def connect_blue(conn_no):
    for i in range(1, len(conn_no)):
        nxt, prv = conn_no[i], conn_no[i - 1]
        node_lst[nxt].prev = node_lst[prv]
        node_lst[prv].nxt_blue = node_lst[nxt]


connect_red([i for i in range(21)])  # 0부터 20
connect_red([21, 22, 23, 29])
connect_red([26, 27, 28, 29])
connect_red([24, 25, 29, 30, 31, 20, 32, 32])

connect_blue([5, 21])
connect_blue([10, 24])
connect_blue([15, 26])


# test
# start_node = node_lst[0]
# end_node = node_lst[32]
#
# node = start_node
# while node != end_node:
#     if node.nxt_blue and node.no != 5 and node.no != 10:
#         node = node.nxt_blue
#         continue
#     node = node.nxt_red


# ---------------로직 시작 ---------------------
def move(cur_node, cnt):
    if cur_node.nxt_blue is not None:  # 시작에서 blue가 있으면
        node = cur_node.nxt_blue
    else:
        node = cur_node.nxt_red

    for _ in range(cnt - 1):  # cnt - 1번 이동
        node = node.nxt_red  # 빨간 노드
    return node


def perm(depth, cur_score):
    if depth == 10:
        ans[0] = cur_score if ans[0] < cur_score else ans[0]
        return

    for i in range(4):  # depth번째 주사위 i번째 말이 이동함
        cur_node = stone[i]

        if cur_node.no == 32:  # 도착지점이면 안들어감
            continue

        move_node = move(cur_node, dice_lst[depth])

        if move_node.no == 32 or move_node not in stone:
            stone[i] = move_node
            perm(depth + 1, cur_score + move_node.score)
            stone[i] = cur_node


ans = [0]
stone = [node_lst[0], node_lst[0], node_lst[0], node_lst[0]]  # 말 4개
perm(0, 0)

print(ans[0])