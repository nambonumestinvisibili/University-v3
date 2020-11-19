import math

f = lambda x: x**3 - (x**6 + 2020)**(1/2)
g = lambda x: 2020/(x**3 + (x**6 + 2020)**(1/2))

for i in range(10000000, 10000010):
    j = i
    print(str(j) +"\tf(x) = " + str(f(j)) + "\tg(x) = " + str(g(j)))

print("----------------------------------------------------------------------------------------")

h = lambda x: x**(-4)*(math.cos(x) - 1 + x**2/2)

def m(x):
    sum = 0
    for i in range(0, 16):
        sum += x**i/math.factorial(i+4)
    return sum

for i in range(955, 1050):
    j = i/1000
    print(str(j) + "\th(x) = " + str(h(j)) + "\tm(x) = " + str(m(j)))

print("----------------------------------------------------------------------------------------")
n = lambda x: math.log(x, 5) - 6
p = lambda x: math.log(x/(5**6))

piecdoszostej = 5**6
for i in range(piecdoszostej-20, piecdoszostej+20):
    j = i
    print(str(j) + "\tn(x) = " + str(n(j)) + "\tp(x) = " + str(p(j)))
