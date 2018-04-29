package Lists;

import java.lang.reflect.Array;
import java.util.*;

public class SinglyLinkedListSortedSet<T> implements SortedSet<T> {
   private int size;
   private Node<T> first;
   private Node<T> last;
   private Node<T> prev; // auxiliary pointer to update last when removing the last element
   private Comparator<T> comparator;

   public SinglyLinkedListSortedSet(Comparator<T> comparator){
       this.size = 0;
       this.first = null;
       this.last = null;
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
        return temp != null && comparator.compare(temp, last.elem) <= 0 && contains(temp, first);
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
           last = new Node<T>(t, null);
           return last;
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
           if (current.tail == null)
               last = prev;
           return current.tail;
       }
       if(comparison > 0){// element is not on list
           return current;
       }
       prev = current;
       current.tail = remove(t,current.tail);
       return current;

    }
    @Override
    public boolean containsAll(Collection<?> collection) {
       for(Object o : collection){
           if(!contains(o))
               return false;
       }
       return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
       int temp = size;
       for(T t:collection)
           add(t);
        return temp>size;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
       int temp = size;
       for(Object o: collection){
            remove(o);
        }
        return size<temp;
    }

    @Override
    public void clear() {
        first = null;
    }

    @Override
    public Comparator<? super T> comparator() {
        return comparator;
    }

    @Override
    public SortedSet<T> subSet(T t, T e1) {
        SinglyLinkedListSortedSet<T> result = new SinglyLinkedListSortedSet<>(comparator);
        for(T elem:this)
            if(comparator.compare(elem,t) < 0 && comparator.compare(elem,e1) > 0)
                result.add(elem);
        return result;
    }
    private void addAtEnd(T elem){
       if(last == null) {
           last = new Node<>(elem, null);
           return;
       }
       last.tail = new Node<>(elem,null);
       last = last.tail;
    }

    @Override
    public SortedSet<T> headSet(T t) {
        SinglyLinkedListSortedSet<T> result = new SinglyLinkedListSortedSet<>(comparator);
        for(T elem:this)
            if(comparator.compare(elem,t) < 0)
                result.add(elem);
        return result;
    }

    @Override
    public SortedSet<T> tailSet(T t) {
        SinglyLinkedListSortedSet<T> result = new SinglyLinkedListSortedSet<>(comparator);
        for(T elem:this)
            if(comparator.compare(elem,t) > 0)
                result.add(elem);
        return result;
    }

    @Override
    public T first() {
        return first.elem;
    }

    @Override
    public T last() {
        return last.elem;
    }

    public static <T extends Comparable<? super T>> SinglyLinkedListSortedSet<T> union(SinglyLinkedListSortedSet<T>... lists){
       int size = lists.length;
       int min;
       SinglyLinkedListSortedSet<T> result = new SinglyLinkedListSortedSet<>(lists[0].comparator);
       Node<T>[] nodes = (Node<T>[]) Array.newInstance(Node.class, size);
       int i = 0;
       for(SinglyLinkedListSortedSet set : lists){
           nodes[i++] = set.first;
       }

        Comparator<T> comparator = lists[0].comparator;
       do{
           min = -1;
           for(int k=0;k<size;k++){
               if(nodes[k] != null) {
                   if (min == -1 || comparator.compare(nodes[k].elem, nodes[min].elem) < 0) {
                       min = k;
                   }else if(nodes[k].elem.equals(nodes[min].elem))
                       nodes[k] = nodes[k].tail;
               }
           }
           if(min != -1) {
               result.addAtEnd(nodes[min].elem);
            nodes[min] = nodes[min].tail;
           }
       }while(min != -1);
    return result;
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
