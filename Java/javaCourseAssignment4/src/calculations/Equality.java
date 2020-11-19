package calculations;

public class Equality extends BinaryOperator {
    public Equality(Expression expr, Expression expr2) {
        super(expr, expr2);
        functionName = "=";
    }

    @Override
    public int calculate() throws Exception {
        if (operand1.calculate() == operand2.calculate()) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
