package calculations;

import javafx.util.Pair;
import java.util.ArrayList;

public class Variable extends Expression {

    private static ArrayList<Pair<String, Integer>> variables = new ArrayList<>();
    String key;

    public Variable(String variable) throws Exception {
        for (Pair<String, Integer> pair : variables){
            if (pair.getKey().equals(variable)){
                key = pair.getKey();
            }
        }
//      TODO:  throw new Exception("Such a variable doesn't exist");
    }

    public Variable(String id, int value){
        int VariableId = getVariableIndex(id);
        if (VariableId != -1){
            variables.remove(VariableId);
        }
        this.key = id;
        variables.add(new Pair<>(key, value));
    }

    public static ArrayList<Pair<String, Integer>> getEnvironment(){
        return variables;
    }

    public static void clearBlockVariables(ArrayList<String> arrayOfBlockVariablesIdsToDelete){
        for( String varId: arrayOfBlockVariablesIdsToDelete){
            int index = variables.indexOf(varId);
            if (index != -1){
                variables.remove(index);
            }
        }
    }
    public int getVariableIndex(String id) {
        int i = 0;
        if (variables.size() == 0) return -1;
        for (Pair<String, Integer> pair : variables) {
            if (pair.getKey().equals(id)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override
    public int calculate() {
        int id = getVariableIndex(key);
        return variables.get(id).getValue();
    }

    @Override
    public String toString() {
        return key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Variable variable = (Variable) o;

        return key == variable.key && calculate() == variable.calculate();
    }


}
