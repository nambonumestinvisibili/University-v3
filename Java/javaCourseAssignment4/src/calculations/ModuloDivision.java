package calculations;

public class ModuloDivision extends BinaryOperator {

    public ModuloDivision(Expression expr, Expression expr2) throws Exception {
        super(expr);
        int operand2Val = expr2.calculate();
        if (operand2Val <= 0) throw new Exception("You must not divide by 0");
        operand2 = expr2;
        functionName = "Modulo";

    }

    @Override
    public int calculate() throws Exception {
        return operand1.calculate() % operand2.calculate();
    }
}
