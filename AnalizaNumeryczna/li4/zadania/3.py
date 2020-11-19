import math
alfa = 0.49

a = 0
b = 1

f = lambda x: x - 0.49

for i in range(1, 10):
    x = (a+b)/2
    fa = f(a)
    fx = f(x)
    realE = abs(x - alfa)
    expectedE = 2**-((i+1))
    print(i, ')', sep="")
    print("f(", x, ') = ', fx)
    print('realE = ', realE, 'expectedE = ', expectedE)
    print()
    if (fx*fa < 0): b = x
    else: a = x
