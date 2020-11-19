f = lambda x: 4040 * ((x**11 + 1)**(1/2) - 1)/(x**11)
g = lambda x: 4040 * 1/((x**11+1)**(1/2)+1)

for i in range(-100, 100):
    if (i == 0):
        continue
    
    i = i/1000
    print(i, "\tf(x) = ", f(i), "\tg(x) = ", g(i))