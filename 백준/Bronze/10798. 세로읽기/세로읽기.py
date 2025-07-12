data = [input() for i in range(5)]
dataLen = [len(s) for s in data]

for i in range(max(dataLen)):
    for j in range(5):
        if(dataLen[j] > i):
            print(data[j][i], end="")