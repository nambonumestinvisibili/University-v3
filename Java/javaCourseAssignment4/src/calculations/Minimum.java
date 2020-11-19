package calculations;

public class Minimum extends BinaryOperator {
    public Minimum(Expression expr, Expression expr2) {
        super(expr, expr2);
        functionName = "Min";

    }

    @Override
    public int calculate() throws Exception {
        return Math.min(operand1.calculate(), operand2.calculate());
    }
}
