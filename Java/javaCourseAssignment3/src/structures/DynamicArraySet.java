package structures;

import javax.naming.NameNotFoundException;
import javax.naming.SizeLimitExceededException;

public class DynamicArraySet extends Set {

    public DynamicArraySet(){
        super();
        setOfPairs = new Pair[2];
        count = 0;
    }

    @Override
    public void insert(Pair pair) throws Exception {

        try {
            search(pair.identifier);
            throw new Exception("A pair with this identifier already exists in this set");
        }
        catch (NameNotFoundException e){
            if (count == setOfPairs.length)
                resizeArray(2 * setOfPairs.length);
            pair.setIndex(count);
            setOfPairs[count] = pair;
            count++;
        }
    }

    private void resizeArray(int newLength){
        Pair[] newSetOfPairs = new Pair[newLength];
        for (int i = 0; i < count; i++){
            newSetOfPairs[i] = setOfPairs[i];
        }
        setOfPairs = newSetOfPairs;
    }

    @Override
    public void delete(Pair pair) {
        try {
            Pair pairToDelete = search(pair.identifier);
            int pairToDeleteIdx = pairToDelete.getIndex();
            int i;
            for ( i = pairToDeleteIdx; i < count - 1; i++){
                setOfPairs[i] = setOfPairs[i+1];
                setOfPairs[i].setIndex(i);
            }
            setOfPairs[i] = null;
            count--;

            if (count < (0.25 * setOfPairs.length)){
                resizeArray(setOfPairs.length/2);
            }
        }
        catch (Exception e) { }
    }
}
