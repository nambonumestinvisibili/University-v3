package calculations;

public abstract class Expression implements ICalculable {

    public static double sum(Expression... expr) throws Exception {
        double result = 0;
        for (Expression e : expr){
            result += e.calculate();
        }
        return result;
    }

    public static double multiply(Expression... expr) throws Exception {
        double result = 0;
        for (Expression e : expr){
            result += e.calculate();
        }
        return result;
    }
}
