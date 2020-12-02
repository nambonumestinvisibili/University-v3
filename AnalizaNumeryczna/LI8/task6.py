import matplotlib.pyplot as plt
import math

ts = [ i/95 for i in range(0, 96)]

xs = [5.5, 8.5, 10.5, 13, 17, 20.5, 24.5, 28, 32.5, 37.5, 40.5, 42.5, 45, 47,
49.5, 50.5, 51, 51.5, 52.5, 53, 52.8, 52, 51.5, 53, 54, 55, 56, 55.5, 54.5, 54, 55, 57, 58.5,
59, 61.5, 62.5, 63.5, 63, 61.5, 59, 55, 53.5, 52.5, 50.5, 49.5, 50, 51, 50.5, 49, 47.5, 46,
45.5, 45.5, 45.5, 46, 47.5, 47.5, 46, 43, 41, 41.5, 41.5, 41, 39.5, 37.5, 34.5, 31.5, 28, 24,
21, 18.5, 17.5, 16.5, 15, 13, 10, 8, 6, 6, 6, 5.5, 3.5, 1, 0, 0, 0.5, 1.5, 3.5, 5, 5, 4.5, 4.5, 5.5,
6.5, 6.5, 5.5]

ys =  [41, 40.5, 40, 40.5, 41.5, 41.5, 42, 42.5, 43.5, 45, 47, 49.5, 53, 57, 59,
59.5, 61.5, 63, 64, 64.5, 63, 61.5, 60.5, 61, 62, 63, 62.5, 61.5, 60.5, 60, 59.5, 59, 58.5,
57.5, 55.5, 54, 53, 51.5, 50, 50, 50.5, 51, 50.5, 47.5, 44, 40.5, 36, 30.5, 28, 25.5, 21.5,
18, 14.5, 10.5, 7.50, 4, 2.50, 1.50, 2, 3.50, 7, 12.5, 17.5, 22.5, 25, 25, 25, 25.5, 26.5,
27.5, 27.5, 26.5, 23.5, 21, 19, 17, 14.5, 11.5, 8, 4, 1, 0, 0.5, 3, 6.50, 10, 13, 16.5, 20.5,
25.5, 29, 33, 35, 36.5, 39, 41]

# h = 1/95
# Lambda = 1/2
n = 95

def findDCurrent(xprev, xcurrent, xnext, yprev, ycurrent, ynext):
    num = (ynext - ycurrent)/(xnext-xcurrent) - (ycurrent-yprev)/(xcurrent-xprev)
    denom = xnext-xprev
    return 6*num/denom

def FindNIFS3Moments(n, args, vals):
    q = [0 for i in range(0, n)]
    u = [0 for i in range(0, n)]
    p = [0 for i in range(0, n)]
    h = [0] + [args[i]-args[i-1] for i in range(1,n+1)]
    lambdy = [0] + [h[i]/(h[i]+h[i+1]) for i in range(1,n)]
    
    for i in range(1, n):
        p[i] = lambdy[i] * q[i-1] + 2
        q[i] = (lambdy[i]-1)/p[i]
        cz1 = (findDCurrent(args[i-1], args[i], args[i+1], vals[i-1], vals[i], vals[i+1]))
        cz2 = (lambdy[i] * u[i-1])
        u[i] = (cz1 - cz2) / p[i]

    Ms = [0 for i in range(n+1)]
    Ms[n-1] = u[n-1]

    for i in range(n-2, 0, -1):
        Ms[i] = u[i] + q[i]*Ms[i+1]
    return Ms

def defineNIFS3(n, args, vals):
    hs = [0] + [args[i]-args[i-1] for i in range(1,n+1)]
    moments = FindNIFS3Moments(n, args, vals)
    s = []
    for i in range(0, n):
        xi = args[i]
        xi1 = args[i+1]
        si = lambda x, xi=xi, xi1=xi1: (1/hs[i+1])*((moments[i]  * (xi1 - x)**3 / 6 + moments[i+1] * (x - xi)**3 / 6 + (vals[i] - moments[i] * hs[i+1] * hs[i+1] / 6) * (xi1 - x) + (vals[i+1] - moments[i+1] * hs[i+1] * hs[i+1] / 6) * (x - xi)))
        s.append(si)
        del si

    #mamy s
    for i in range(5):
        print(f"funkcja s{i} dla {args[i]} przyjmuje {s[i](args[i])}")
    
    arguments = [i/950 for i in range (0, 950)]
    for i in range(0, 31):
        if i%10 == 0:
            print(f"funkcja s{math.floor(i/10)} dla {arguments[i]} przyjmuje {s[math.floor(i/10)](arguments[i])}")
            
    coordinate = [s[math.floor(j/10)](arguments[j]) for j in range(0, 950) ]
    print(coordinate[9:12])
    # return coordinate




# sx = defineNIFS3(n, ts, xs)
# sy = defineNIFS3(n, ts, ys)

# arguments = [i/950 for i in range (0, 950)]
# fstcoordinate = []
# sndcoordinate = [sy[math.floor(j/10)](arguments[j]) for j in range(0, 950) ]

# for j in range(0, 950):
#     zm = sx[math.floor(j/10)](arguments[j])
#     fstcoordinate.append(zm)

sxs = defineNIFS3(n, ts, xs)
sys = defineNIFS3(n, ts, ys)

plt.plot(sxs, sys)
plt.show()


# plt.rcParams['legend.fontsize'] = 10

# fig = plt.figure()
# ax = fig.gca(projection='3d')

# ax.plot(arguments, fstcoordinate, sndcoordinate)
# ax.legend()
# plt.show()
# plt.plot(fstcoordinate, sndcoordinate)
# plt.show()



