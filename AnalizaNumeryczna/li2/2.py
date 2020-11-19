import itertools
from matplotlib import pyplot as plt

def parse_bin(s):
    if(s[0] == '-'):
        t = s[1:].split('.')
        return -1 * (int(t[0], 2) + int(t[1], 2)) / 2.**len(t[1])
    else:
        t = s.split('.')
        return int(t[0], 2) + int(t[1], 2) / 2.**len(t[1])

def generateProduct():
    result = []
    zeroones = itertools.product('01', repeat=3)
    for each in zeroones:
        result.append("0.1" + "".join(list(each)))
    result = list(map(float, result))
    res = []
    for each in result:
        res.append('%.6f'%(each))
        res.append('%.6f'%(-each))
        res.append('%.6f'%(each*10))
        res.append('%.6f'%(-each*10))
        res.append('%.6f'%(each*0.1))
        res.append('%.6f'%(-each*0.1))
    print(res)
    res = list(map(parse_bin, res))
    return res

zeroes = [0 for i in range(48)]

plt.axis([-2,2,-1,1])
plt.plot(generateProduct(), zeroes, 'ro')
plt.show()