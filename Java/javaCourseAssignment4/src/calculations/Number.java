package calculations;

import java.util.Objects;

public class Number extends Expression {
    private int value;

    public Number(int value){
        this.value = value;
    }

    @Override
    public int calculate() {
        return value;
    }

    @Override
    public String toString(){
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return value == number.value;
    }
}
