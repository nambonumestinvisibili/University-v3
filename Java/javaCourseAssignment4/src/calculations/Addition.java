package calculations;

public class Addition extends BinaryOperator {

    public Addition(Expression expr, Expression expr2) {
        super(expr, expr2);
        functionName = "Add";
    }

    @Override
    public int calculate() throws Exception {
        return operand1.calculate() + operand2.calculate();
    }
}
