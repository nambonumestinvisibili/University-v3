def funkcja(n):
    if n == 0:
        return 1
    elif n == 1:
        return -1/7
    else:
        return  (1/7)*(69*funkcja(n-1)+10*funkcja(n-1))

for i in range(2, 50):
    print(funkcja(i))