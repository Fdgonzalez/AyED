package Lists;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public class SinglyLinkedListSet<T> implements Set<T> {
    private int size;
    private Node<T> first;

    public SinglyLinkedListSet() {
        this.size = 0;
        this.first = null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    @SuppressWarnings("unchecked") // No se puede implementar con el generic
    public boolean contains(Object o) {
        T temp = (T) o;
        return temp != null && contains(temp, first);
    }
    private boolean contains(T elem, Node<T> current) {
        return current != null && (current.elem == elem || contains(elem, current.tail));
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> current = first;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (current == null)
                    throw new NoSuchElementException();
                T temp = current.elem;
                current = current.tail;
                return temp;
            }
        };
    }

    @Override
    public Object[] toArray() {
        Node<T> current = first;
        Object[] result = new Object[size];
        for(int i=0;i<size;i++){
            result[i] = current.elem;
            current = current.tail;
        }
        return result;
    }

    @Override
    public <T1> T1[] toArray(T1[] t1s) {
        return null;
    }

    @Override
    public boolean add(T elem) {
        if(elem == null)
            return false;
        if(contains(elem))
            return false;
        first = add(first,elem);
        size++;
        return true;
    }

    private Node<T> add(Node<T> head, T elem) {
        return new Node<T>(elem,head);
    }

    @Override
    @SuppressWarnings("unchecked") // No se puede implementar con el generic hay que hacer un cast :(
    public boolean remove(Object o) {
        T temp = (T) o;
        if(temp == null)
            return false;
        int tempSize = size;
        first = remove(temp, first);
        return tempSize>size;
    }
    public Node<T> remove(T elem, Node<T> current){
        if(current == null)
            return null;
        if(elem.equals(current.elem)){
            size--;
            return current.tail;
        }
        current.tail = remove(elem,current.tail);
        return current;
    }

    @Override
    @SuppressWarnings("unchecked") // No se puede implementar con el generic
    public boolean addAll(Collection collection) {
        for(Object o : collection){
            add((T) o);//que lluevan los casts!
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection collection) {
        return false;
    }

    @Override
    public boolean containsAll(Collection collection) {
        return false;
    }

    @Override
    public void clear() {
        first = null;
    }
    private static class Node<T> {
        T elem;
        Node<T> tail;

        private Node(T elem, Node<T> tail) {
            this.elem = elem;
            this.tail = tail;
        }
    }
}
