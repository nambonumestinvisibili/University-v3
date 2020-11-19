package instructions;

import calculations.Expression;
import calculations.Variable;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class Assignment extends Instruction{
    String id;
    Expression value;

    public Assignment(String id, Expression value){
        this.id = id;
        this.value = value;
    }

    @Override
    public void execute() throws Exception {
        Variable v = new Variable(id, value.calculate());
        System.out.println(v.calculate());
    }

}
