package calculations;

public class ReverseSign extends UnaryOperator {

    public ReverseSign(Expression expr) {
        super(expr);
        functionName = "-";
    }

    @Override
    public int calculate() throws Exception {
        return (-1) * operand1.calculate();
    }
}
