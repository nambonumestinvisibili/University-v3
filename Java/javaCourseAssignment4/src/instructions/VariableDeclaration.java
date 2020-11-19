package instructions;

import calculations.Variable;

public class VariableDeclaration extends Instruction {
    String id;

    public VariableDeclaration(String id){
        this.id = id;
    }

    @Override
    public void execute() {
        Variable v = new Variable(id, 0);
    }

    public String getDeclaredVariableId(){
        return id;
    }
}
