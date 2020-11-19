package calculations;

public class Division extends BinaryOperator {

    public Division(Expression expr, Expression expr2) throws Exception {
        super(expr);
        int operand2Val = expr2.calculate();
        if (operand2Val == 0) throw new Exception("You must not divide by 0");
        operand2 = expr2;
        functionName = "Div";


    }

    @Override
    public int calculate() throws Exception {
        return operand1.calculate() / operand2.calculate();
    }
}
