package calculations;

public class Exponentation extends BinaryOperator {

    public Exponentation(Expression expr, Expression expr2) {
        super(expr, expr2);
        functionName = "Pow";
    }

    @Override
    public int calculate() throws Exception {
        return (int) Math.pow(operand1.calculate(), operand2.calculate());
    }
}


