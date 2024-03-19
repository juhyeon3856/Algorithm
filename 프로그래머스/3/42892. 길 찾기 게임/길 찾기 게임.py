import sys
sys.setrecursionlimit(10**6)

def solution(nodeinfo):
    tree, start = makeTree(nodeinfo)
    pre = preorder(tree, [], start)
    post = postorder(tree, [], start)
    return [pre, post]

def preorder(tree, result, start):
    result.append(start)
    for node in tree[start]:
        if node:
            result = preorder(tree, result, node)
    return result  

def postorder(tree, result, start):
    for node in tree[start]:
        if node:
            result = postorder(tree, result, node)
    result.append(start)
    return result

def makeTree(nodeinfo):
    for i in range(len(nodeinfo)):
        nodeinfo[i].append(i+1)
    nodeinfo.sort(key = lambda x: (-x[1], x[0]))
    check = nodeinfo[0][1]
    x_lim = []
    nodeNum = []
    line = []
    for node in nodeinfo:
        if check != node[1]:
            check = node[1]
            lim, nodeNum = putLine(line, x_lim, nodeNum)
            x_lim = x_lim + lim
            x_lim.sort()
            line = [[node[0], node[2]]]
        else:
            line.append([node[0], node[2]])
    _, nodeNum = putLine(line, x_lim, nodeNum)
    tree = [[0, 0] for _ in range(len(nodeinfo)+1)]
    for i in range(len(nodeNum)-1):
        j = 0
        for n in nodeNum[i]:
            if n == 0:
                j+=1
            elif len(nodeNum[i+1]) == j+1:
                tree[n][0] = nodeNum[i+1][j]
                break
            elif len(nodeNum[i+1]) == j+2:
                tree[n] = [nodeNum[i+1][j], nodeNum[i+1][j+1]]
                break
            else:
                tree[n] = [nodeNum[i+1][j], nodeNum[i+1][j+1]]
                j+=2
    return tree, nodeNum[0][0]

def putLine(line, x_lim, nodeNum):
    lim = []
    apnd = []
    x = line[0]
    for i in range(len(x_lim)):
        if x[0] < x_lim[i]:
            apnd.append(x[1])
            lim.append(x[0])
            line = line[1:]
            if len(line) > 0:
                x = line[0]
            else: 
                break
        else:
            apnd.append(0)
    if len(line) > 0:
        apnd.append(line[0][1])
        lim.append(line[0][0])
    nodeNum.append(apnd)
    return lim, nodeNum