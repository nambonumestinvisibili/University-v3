from math import cos, sin, log, exp
def olver(xn, f, fprim, fbis):
    second = f(xn)/fprim(xn)
    third = 0.5 * fbis(xn)/fprim(xn)
    fourth = (f(xn)/fprim(xn))**2
    return xn - second - third * fourth

f = lambda x: sin(x) - 0.5
fprim = lambda x: cos(x)
fbis = lambda x: -sin(x)
xn = 1

#działa już po 4 iteracjach z dokładnością do 16 cyfr
print("Funkcja sin(x) - 0.5")
print("Kolejne przybliżenia metodą olvera:")
results = []
results.append(xn)
for _ in range(10):
    xn = olver(xn, f, fprim, fbis)
    results.append(xn)
    print(xn) 


def convergenceOrder(xn, xn1, xn2, xn3):
    num = log(abs((xn-xn1)/(xn1-xn2)))
    denom = log(abs((xn1-xn2)/(xn2-xn3)))
    return num/denom

starting = 4
print("Wykładnik zbieżności", convergenceOrder(results[starting], results[starting-1], results[starting-2], results[starting-3]))

print("Funkcja x^3 + x")
print("Kolejne przybliżenia metodą olvera:")
g = lambda x: x**3 + x
gprim = lambda x: 3*x**2 +1
gbis = lambda x: 6 * x
xn = 0.4
results = []
results.append(xn)
for _ in range(10):
    xn = olver(xn, g, gprim, gbis)
    results.append(xn)
    print(xn)
starting = 5
print("Wykładnik zbieżności", convergenceOrder(results[starting], results[starting-1], results[starting-2], results[starting-3]))

print()
print("Funkcja x - exp(-x)")
print("Kolejne przybliżenia metodą olvera:")
h = lambda x: x - exp(-x)
hprim = lambda x: 1 + exp(-x)
hbis = lambda x: - exp(-x)
xn = 0.1
results = []
results.append(xn)
for _ in range(10):
    xn = olver(xn, h, hprim, hbis)
    results.append(xn)
    print(xn)
starting = 3
print("Wykładnik zbieżności", convergenceOrder(results[starting], results[starting-1], results[starting-2], results[starting-3]))

print()
print("Funkcja x^2 - 1 - x")
print("Kolejne przybliżenia metodą olvera:")
h = lambda x: x**2 - 1 - x
hprim = lambda x: 2*x - 1
hbis = lambda x: 2
xn = 0.1
results = []
results.append(xn)
for _ in range(10):
    xn = olver(xn, h, hprim, hbis)
    results.append(xn)
    print(xn)
starting = 5
print("Wykładnik zbieżności", convergenceOrder(results[starting], results[starting-1], results[starting-2], results[starting-3]))
