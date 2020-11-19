package structures;

public interface OrderedSequence<T extends Comparable<T>> {
    void insert(T elem);
    boolean remove(T elem);
    T min();
    T max();
    T at(int idx);
    boolean search(T elem);
    int index(T elem);
}
