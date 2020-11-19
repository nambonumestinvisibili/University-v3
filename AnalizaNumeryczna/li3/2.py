def quadratic(a, b, c):
    delta = (b**2 - 4*a*c)**(1/2)
    return "x1 = " + str(( - delta - b )/2*a) + "\tx2 = " + str((delta - b)/2*a)

def betterQuadratic(a, b, c):
    delta = (b**2 - 4*a*c)**(1/2)
    x1 = (-b - delta) / 2*a
    x2 = c/(a*x1)
    return "x1 = " + str(x1) + "\tx2 = " + str(x2)

print(quadratic(1, 600, 10))
print(betterQuadratic(1, 600, 10))
print()

print(quadratic(1, 10**4, 1))
print(betterQuadratic(1, 10**4, 1))
print()

print(quadratic(1, 10**8, 1))
print(betterQuadratic(1, 10**8, 1))
print()