
zm = 0

for k in range(20000):
    zm += (-1)**k/(2*k+1)

zm = zm*4

print(zm)