package Lists;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SinglyLinkedListSortedSetTest {

    @Test
    public void size() {
        SinglyLinkedListSortedSet<Integer> test = new SinglyLinkedListSortedSet<Integer>(Integer::compareTo);
        assertEquals(0,test.size());
        test.add(5);
        assertEquals(1,test.size());
        test.add(6);
        assertEquals(2,test.size());
    }

    @Test
    public void isEmpty() {
        SinglyLinkedListSortedSet<Integer> test = new SinglyLinkedListSortedSet<Integer>(Integer::compareTo);
        assertEquals(true,test.isEmpty());
        test.add(5);
        assertEquals(false,test.isEmpty());
        test.remove(5);
        assertEquals(true,test.isEmpty());
    }

    @Test
    public void contains() {
        SinglyLinkedListSortedSet<Integer> test = new SinglyLinkedListSortedSet<Integer>(Integer::compareTo);
        test.add(5);
        assertEquals(true,test.contains(5));
        assertEquals(false,test.contains(6));
        test.add(6);
        assertEquals(true,test.contains(6));
    }

    @Test
    public void iterator() {
        SinglyLinkedListSortedSet<Integer> test = new SinglyLinkedListSortedSet<Integer>(Integer::compareTo);
        test.add(5);
        test.add(6);
        Iterator<Integer> it = test.iterator();
        assertEquals(5,it.next().intValue());
        assertEquals(6,it.next().intValue());
        assertEquals(false,it.hasNext());
    }

    @Test
    public void toArray() {
        SinglyLinkedListSortedSet<Integer> test = new SinglyLinkedListSortedSet<Integer>(Integer::compareTo);
        test.add(0);
        test.add(1);
        test.add(2);
        Integer[] expected = {0, 1, 2};
        assertArrayEquals(expected, test.toArray());
    }

    @Test
    public void addAll() {
    }

    @Test
    public void clear() {
        SinglyLinkedListSortedSet<Integer> test = new SinglyLinkedListSortedSet<Integer>(Integer::compareTo);
        test.add(0);
        test.add(1);
        test.add(2);
        test.clear();
        assertEquals(true,test.isEmpty());

    }

    @Test
    public void union() {
        SinglyLinkedListSortedSet<Integer> test = new SinglyLinkedListSortedSet<Integer>(Integer::compareTo);
        test.add(0);
        test.add(1);
        test.add(2);
        SinglyLinkedListSortedSet<Integer> test2 = new SinglyLinkedListSortedSet<Integer>(Integer::compareTo);
        test2.add(1);
        test2.add(5);
        test2.add(10);
        SinglyLinkedListSortedSet<Integer> test3 = new SinglyLinkedListSortedSet<Integer>(Integer::compareTo);
        test3.add(20);
        test3.add(4);
        test3.add(6);
        SinglyLinkedListSortedSet<Integer> union = SinglyLinkedListSortedSet.union(test,test2,test3);
    }
}