package structures;

import java.util.Iterator;

public class OrderedList<T extends Comparable<T>> implements OrderedSequence<T>, Iterable<T> {

    @Override
    public Iterator<T> iterator() {
        return new OrderedListIterator<T>(this);
    }

    private class OrderedListIterator<T  extends Comparable<T>> implements Iterator<T> {
        Node<T> current;

        public OrderedListIterator(OrderedList<T> list){
            this.current = (Node<T>) list.getHead();
        }
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T data = current.data;
            current = current.next;
            return data;
        }
    }

    private class Node<T extends Comparable<T>>{
        private Node<T> next;
        private T data;

        Node(T elem){
            this.data = elem;
            this.next = null;
        }
    }

    private Node<T> start;
    private int size;

    public OrderedList(T elem){
        this.start = new Node<>(elem);
        start.next = null;
        this.size = 1;
    }

    private Node<T> getHead(){
        return this.start;
    }

    @Override
    public void insert(T elem) {

        if (elem == null) throw new NullPointerException();
        Node<T> newNode = new Node<>(elem);

        if (size == 0){
            this.start = newNode;
            size++;
            return;
        }

        Node<T> current = this.start;

        if (size == 1) {
            if (elem.compareTo(current.data) < 0){
                this.start = newNode;
                this.start.next = current;
            }
            else {
                this.start.next = newNode;
            }
        }
        else {
            if (this.start.data.compareTo(newNode.data))
            while (current.next != null){
                if (current.next.data.compareTo(newNode.data) > 0) break;
                current = current.next;
            }

            if (current.next == null) {
                current.next = newNode;
            }
            else {
                Node<T> rest = current.next;
                newNode.next = rest;
                current.next = newNode;
            }
        }
        size++;

    }

    @Override
    public boolean remove(T elem) {
        if (elem == null) throw new NullPointerException();

        Node<T> current = this.start;

        if (size == 0) return false;

        if (current.data == elem){
            this.start = this.start.next;
            size--;
            return true;
        }

        while(current.next != null){
            if (current.next.data == elem) break;
            current = current.next;
        }

        if (current.next == null) return false;
        else current.next = current.next.next;
        size--;
        return true;
    }

    @Override
    public T min() {
        return this.at(0);
    }

    @Override
    public T max() {
        return this.at(size-1);
    }

    @Override
    public T at(int idx) {
        if (idx < 0 || idx >= size) throw new IllegalArgumentException("Invalid index");

        Node<T> curr = this.start;
        for (int i = 0; i < idx; i++){
            curr = curr.next;
        }
        return curr.data;
    }

    @Override
    public boolean search(T elem) {
        if (elem == null) throw new NullPointerException();

        Node<T> current = this.start;
        for (int i = 0; i < size; i++){
            if (current.data == elem){
                return true;
            }
        }
        return false;
    }

    @Override
    public int index(T elem) {
        if (elem == null) throw new NullPointerException();

        Node<T> current = this.start;
        for (int i = 0; i < size; i++){
            if (current.data == elem){
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    @Override
    public String toString() {
        Node<T> current = this.start;
        String result = "[";
        while (current != null){
            result += current.data + ", ";
            current = current.next;
        }
        return result + "\b\b]";
    }

    public int getSize(){
        return size;
    }
}
