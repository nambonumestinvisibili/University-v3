package calculations;

public class DiscreteLogarithm extends BinaryOperator{
    public DiscreteLogarithm(Expression expr, Expression expr2) throws Exception {
        int exprVal = expr.calculate();
        int expr2Val = expr.calculate();
        if (exprVal > 0 && exprVal != 1 && expr2Val > 0){
            operand1 = expr;
            operand2 = expr2;
            functionName = "DiscreteLog";
        }
        else throw new Exception("Incorrect logarithm");
    }

    @Override
    public int calculate() throws Exception {
        return (int) (Math.log(operand1.calculate())/Math.log(operand2.calculate()));
    }
}
