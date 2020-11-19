import math 
from math import cos
from math import sin

PI6 = math.pi/6

f1 = lambda x: 4 * math.cos(x)**2 - 3
f2 = lambda x: -16 * cos((x + PI6)/2) * cos((x - PI6)/2) * sin ((x + PI6)/2) * sin((x - PI6)/2)

print(f1(PI6))
print(f2(PI6))



g1 = lambda x: x**(-3) * (math.pi/2 - x - math.atan(1/x))

def g2(x):
    s = 0
    for i in range(0, 15, 2):
        s += (-1)**(i+1) * x**i / (i+3)
    return s


for i in range(-20, 20):
    if i == 0:
        continue
    j = i/1000
    print("x = ", j,"\t g1(x) =", g1(j), "\t g2(x) = ", g2(j))