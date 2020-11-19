package calculations;

public class Factorial extends UnaryOperator{

    public Factorial(Expression expr) {
        super(expr);
        functionName = "!";
    }

    @Override
    public int calculate() throws Exception {
        int operandValue = operand1.calculate();
        if (operandValue <= 0) throw new Exception("Factorial cannot take negative arguments");
        int temp = 1;
        for (int i = 1; i <= operandValue; i++){
            temp *= i;
        }
        return temp;
    }
}
