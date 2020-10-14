import math
f = lambda x: 12120*((x - math.sin(x))/x**3)


for i in range(11,20):
    print(f(10**(-i)))