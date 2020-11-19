import math

def bisect(a, b, f, e=1/(10**5)):
    x = (a+b)/2
    fx = f(x)
    fa = f(a)

    while(abs(fx) > e):
        if (fx * fa < 0):
            b = x
        else:
            a = x
        x = (a+b)/2
        fx = f(x)
        fa = f(a)
    print ("f(", x, ") = ", fx)

f = lambda x: x**2 - 2*math.cos(3*x + 1)

bisect(-1, 0, f)
bisect(0, 1, f)

