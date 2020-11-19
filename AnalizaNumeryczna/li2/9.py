
def pin(k):
    if(k == 1): return 2
    else:
        return 2**(k-1) * (((1 - ((1 - (pin(k-1)/2**(k-1))**2)**(1/2))) * 2)**(1/2))

def betterpin(k):
    if (k == 1):
        return 2
    else:
        return ((2 * betterpin(k-1)**2)/(1 + (1 - (pin(k-1)/2**(k-1))**2)**(1/2)))**(1/2)

for m in range(1, 30):
    print("------------------------")
    print(m)
    print(pin(m))
    print(betterpin(m))