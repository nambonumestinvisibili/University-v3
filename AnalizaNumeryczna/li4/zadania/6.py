#for future, moze sie zapetlic bo moze byc xn = xn+1


def newtons(x, a, function, maksIters=20):
    for _ in range(maksIters):
        x = function(x, a)
    print(x)

def function(x, a):
    return 3*x/2 - a * x**3 / 2


Iters = 5
print("Maszynowa 1/sqrt(2):")
print(1/(2)**(1/2))

newtons(0.818, 2, function, Iters)
newtons(0.5, 2, function, Iters)
newtons(0.3, 2, function, Iters)
newtons(0.2, 2, function, Iters)
newtons(0.1, 2, function, Iters)
newtons(0.05, 2, function, Iters)
newtons(1.1, 2, function, Iters)
# dla a = 2 eksperymentalnie dobre x to od 0.2 do 1
# matematyka mowi ze od 0.817 do 0.82
# dla dobrych matematycznie wystarczy 5 iteracji
# by być blisko dokładności maszynowej
