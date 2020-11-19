package calculations;

public class Multiplication extends BinaryOperator {

    public Multiplication(Expression expr, Expression expr2) {
        super(expr, expr2);
        functionName = "Mult";
    }

    @Override
    public int calculate() throws Exception {
        return operand1.calculate() * operand2.calculate();
    }
}
