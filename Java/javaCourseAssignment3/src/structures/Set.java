package structures;
import javax.naming.NameNotFoundException;

public abstract class Set {
    protected Pair[] setOfPairs;
    int count;

    public Set(){
        count = 0;
    }

    public Pair search(String identifier) throws Exception {
        for (Pair pair : setOfPairs){
            if (pair == null) break;
            if (pair.identifier.equals(identifier)) return pair;
        }
        throw new NameNotFoundException("There is no Pair with " + identifier + " identifier");
    }
    public abstract void insert(Pair pair) throws Exception;
    public abstract void delete(Pair pair);
    public double read(Pair pair) throws Exception {
        try {
            Pair pairInSet = search(pair.identifier);
            return pairInSet.getValue();
        }
        catch (Exception e){
            throw new NameNotFoundException();
        }
    }
    public void edit(Pair pair) throws Exception {
        try {
            Pair pairInSet = search(pair.identifier);
            pairInSet.setValue(pair.getValue());
        }
        catch (Exception e){
            throw new NameNotFoundException();
        }
    }
    public void clean() throws Exception {
        for (Pair pair : setOfPairs) pair = null;
    }
    public int count(){
        return count;
    };
    @Override
    public String toString(){
        String res = "ArraySet[";
        for (Pair pair : setOfPairs) {
            if (pair == null) {
                res += ", null";
            }
            else {
                res += pair.toString() + ", ";
            }
        }
        return res + "]";
    }
}
