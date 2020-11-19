package instructions;

import calculations.Expression;
import calculations.Variable;

import java.util.Scanner;

public class ReadStream extends Instruction {
    String variableName;

    public ReadStream(String variableName){
        this.variableName = variableName;
    }

    @Override
    public void execute() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter input:");
        String strVal = scanner.next();
        Variable v = new Variable(variableName, Integer.parseInt(strVal));
    }
}
