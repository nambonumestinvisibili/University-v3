rMinusG = [0.763907023, 0.543852762, 0.196247370, 0.009220859]
aMinusG = [0.605426053, 0.055322784, 0.004819076, 0.000399783]

def order(en1, en, p):
    return abs(en1)/(abs(en)**p)

# p = 1
for a in range(1, 6):
    print([order(rMinusG[i], rMinusG[i-1], a) for i in range(1, 4)])

print("rosjanie mają szybszą zbieżnosć p = 3, dla C ~= 1.21")
print("-")

for p in range(1,6):
    print([order(aMinusG[i], aMinusG[i-1], p) for i in range(1, 4)])
print("amerykańska zbieżność : p = 1 dla C ~= 0.09")
