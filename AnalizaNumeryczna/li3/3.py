def cardano(r, q):
    return (r + (q**3 + r**2)**(1/2))**(1/3) + (r - (q**3 + r**2)**(1/2))**(1/3)

def betterCardano(r, q):
    denom = (r + (q**3 + r**2)**(1/2))**(2/3) + (1/ (r + (q**3 + r**2)**(1/2)))* q**2 + q
    return 2*r/denom

print(cardano(10**6, 1))
print(betterCardano(10**6, 1))
print()

print(cardano(10**3, 5))
print(betterCardano(10**3, 5))
print()

print(cardano(10**2, 10))
print(betterCardano(10**2, 10))
print()
