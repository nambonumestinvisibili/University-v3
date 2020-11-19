package structures;
import com.sun.istack.internal.Nullable;

import java.lang.Character;

public class Pair {
    public final String identifier;
    private double value;
    @Nullable
    private int index;

    public Pair(String identifier, double value) {
        if (identifier == null || identifier == "" ||
                !isStringLowerCase(identifier)) throw new IllegalArgumentException("Identifier " +
                "ought not to be null or empty or consisting of uppercase characters");

        this.identifier = identifier;
        this.value = value;
    }

    private boolean isStringLowerCase(String str){
        char[] charArray = str.toCharArray();
        for (char character : charArray){
            if (!Character.isLowerCase(character)){
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString(){
        return "Pair<" + this.identifier + ", " + this.value + ">";
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof Pair){
            return this.identifier == ((Pair) obj).identifier
                    && this.value == ((Pair) obj).getValue();
        }
        return false;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
