package calculations;

public class Substraction extends BinaryOperator{
    public Substraction(Expression expr, Expression expr2) {
        super(expr, expr2);
        functionName = "Sub";

    }

    @Override
    public int calculate() throws Exception {
        return operand1.calculate() - operand2.calculate();
    }
}
