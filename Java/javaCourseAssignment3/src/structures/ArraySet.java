package structures;

import javax.naming.NameNotFoundException;
import javax.naming.SizeLimitExceededException;

public class ArraySet extends Set {

    public ArraySet(int size){
        super();
        if (size < 2) throw new IllegalArgumentException("Size of ArraySet ought not to be less than 2");
        setOfPairs = new Pair[size];
        count = 0;
    }

    @Override
    public void insert(Pair pair) throws Exception {
        if (count == setOfPairs.length)
            throw new SizeLimitExceededException("The ArraySet is full");

        try {
            search(pair.identifier);
            throw new Exception("A pair with this identifier already exists in this set");
        }
        catch (NameNotFoundException e){
            pair.setIndex(count);
            setOfPairs[count] = pair;
            count++;
        }
    }

    @Override
    public void delete(Pair pair){
        try {
            Pair pairToDelete = search(pair.identifier);
            int pairToDeleteIdx = pairToDelete.getIndex();
            int i;
            for ( i = pairToDeleteIdx; i < count - 1; i++){
                setOfPairs[i] = setOfPairs[i+1];
                setOfPairs[i].setIndex(i);
            }
            setOfPairs[i] = null;
        }
        catch (Exception e) { }
    }
}
