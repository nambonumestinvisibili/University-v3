package calculations;

public class GreaterThan extends BinaryOperator {
    public GreaterThan(Expression expr, Expression expr2) {
        super(expr, expr2);
        functionName = ">";

    }

    @Override
    public int calculate() throws Exception {
        if (operand1.calculate() > operand2.calculate()) return 1;
        else return 0;
    }
}

