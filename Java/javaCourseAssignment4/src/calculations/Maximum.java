package calculations;

public class Maximum extends BinaryOperator {
    public Maximum(Expression expr, Expression expr2) {
        super(expr, expr2);
        functionName = "Max";

    }

    @Override
    public int calculate() throws Exception {
        return Math.max(operand1.calculate(), operand2.calculate());
    }
}
