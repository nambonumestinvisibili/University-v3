#Float64 - double precision
#Float32 - single precision

f(x::Float64) = 4040*(((x^11+1)^(0.5))-1)/x^11
println("Funkcja bez przekształceń:")
println(f(0.001))

g(x::Float64) = 4040/((((x^11)+1)^(0.5))+1)
println("Z przekształceniem:")
println(g(0.001))

############################################


# f2(x::Float32) = 4040*(((x^11+1)^(0.5))-1)/x^11
# println("Funkcja bez przekształceń:")
# println(f2(convert(Float32, 0.001)))

# g2(x::Float32) = 4040/((((x^11)+1)^(0.5))+1)
# println("Z przekształceniem:")
# println(g2(convert(Float32, 0.001)))