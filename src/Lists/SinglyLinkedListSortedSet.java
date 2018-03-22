package Lists;

import java.util.*;

public class SinglyLinkedListSortedSet<T> implements Set<T> {
   private int size;
   private Node<T> first;
   private Comparator<T> comparator;

   public SinglyLinkedListSortedSet(Comparator<T> comparator){
       this.size = 0;
       this.first = null;
       this.comparator = comparator;
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
    @SuppressWarnings("unchecked")
    public boolean contains(Object o) {
        T temp = (T) o;
        return temp != null && contains(temp,first);
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
    public boolean add(T t) {
        if(t == null)
            return false;
        int tempSize = size;
        first = add(t, first);
        return size > tempSize;
    }
    private Node<T> add(T t, Node<T> current){
       if(current == null) {
           size++;
           return new Node<T>(t, null);
       }
       int comparison = comparator.compare(current.elem,t);
       if(comparison == 0) // Sets can't have duplicate elements
           return current;
        if(comparison > 0 ) { // current.element > t  -> t goes before current node
            size++;
            return new Node<T>(t, current);
        }
       current.tail = add(t,current.tail);
       return current;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean remove(Object o) {
        T temp = (T) o;
        if(temp == null){
            return false;
        }
        int tempSize = size;
        first = remove(temp,first);
        return tempSize > size;
    }
    private Node<T> remove(T t,Node<T> current){
       int comparison = comparator.compare(current.elem,t);
       if(comparison == 0){
           size--;
           return current.tail;
       }
       if(comparison > 0){// element is not on list
           return current;
       }
       current.tail = remove(t,current.tail);
       return current;

    }
    @Override
    public boolean containsAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return false;
    }

    @Override
    public void clear() {
        first = null;
    }

    private static class Node<T> {
        T elem;
        Node<T> tail;

        private Node(T elem, Node<T> tail){
            this.elem = elem;
            this.tail = tail;
        }
    }
}
