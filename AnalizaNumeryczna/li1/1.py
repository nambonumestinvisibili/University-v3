f = lambda x: 4040*(((x**11+1)**(0.5))-1)/x**11
print("Funkcja bez przekształceń:")
print(f(0.001))

g = lambda x: 4040/((((x**11)+1)**(0.5))+1)
print("Z przekształceniem:")
print(g(0.001))
