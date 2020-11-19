def newtons(a, x, function, maksIters=20):
    for _ in range(maksIters):
        x = function(a, x)
    return x    

def function(a, x):
    return x/2  + a/(2*x)

# a = m * 2^c
def root(a):
    m = a
    c = 0

                                                                                                #zamiana liczby a na m*2**c
    # m in [1/2, 1)
    while(m > 1):
        m /= 2
        c += 1
    
    if (c % 2):
                                                                                                #a = m*2^(2k+1) --> sqrt(a) = sqrt(2m)* 2**k
        c -= 1
        c = c/2
        m = newtons(2*m, 2*m, function)
    else:
                                                                                                #a = m*2^(2k) --> sqrt(a) = sqrt(m)* 2**k
        c = c/2
        m = newtons(m, m, function)
    
    result = m* 2**c
    print('pierwiastek z ', a, ' = ', result)


args = [2, 3, 4, 25, 50]
results = [root(i) for i in args]