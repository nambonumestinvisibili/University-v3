f32(x::Float32) = 12120*((x - sin(x))/x^3)
f64(x::Float64) = 12120*((x - sin(x))/x^3)

x32 = convert(Float32, 10)
x64 = 10.0::Float64

println("i\t\tf32(10^-i)\t\tf64(10^-i)")
for i=11:20
    println(i, "\t\t", convert(Float32, f32(x32^(-i))), "\t\t", convert(Float64, f64(x64^(-i))))
end