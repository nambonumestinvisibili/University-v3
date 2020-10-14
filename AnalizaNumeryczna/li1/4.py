import math

io = math.log(2021/2020)
print("0 = ", io)
for i in range(1,20):
    print(i, " = ", io)
    io = 1/i - 2020*io