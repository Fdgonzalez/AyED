package Lists;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class SinglyLinkedListSetTest {

    @Test
    public void size() {
        SinglyLinkedListSet<Integer> test = new SinglyLinkedListSet<Integer>();
        assertEquals(0,test.size());
        test.add(5);
        assertEquals(1,test.size());
        test.add(6);
        assertEquals(2,test.size());
    }

    @Test
    public void isEmpty() {
        SinglyLinkedListSet<Integer> test = new SinglyLinkedListSet<Integer>();
        assertEquals(true,test.isEmpty());
        test.add(5);
        assertEquals(false,test.isEmpty());
        test.remove(5);
        assertEquals(true,test.isEmpty());
    }

    @Test
    public void contains() {
        SinglyLinkedListSet<Integer> test = new SinglyLinkedListSet<Integer>();
        test.add(5);
        assertEquals(true,test.contains(5));
        assertEquals(false,test.contains(6));
        test.add(6);
        assertEquals(true,test.contains(6));
    }

    @Test
    public void iterator() {
        SinglyLinkedListSet<Integer> test = new SinglyLinkedListSet<Integer>();
        test.add(5);
        test.add(6);
        Iterator<Integer> it = test.iterator();
        assertEquals(6,it.next().intValue());
        assertEquals(5,it.next().intValue());
    }

    @Test
    public void toArray() {
        SinglyLinkedListSet<Integer> test = new SinglyLinkedListSet<Integer>();
        test.add(0);
        test.add(1);
        test.add(2);
        Integer[] expected = {2, 1, 0};
        assertArrayEquals(expected, test.toArray());
    }

    @Test
    public void addAll() {
    }

    @Test
    public void clear() {
        SinglyLinkedListSet<Integer> test = new SinglyLinkedListSet<Integer>();
        test.add(0);
        test.add(1);
        test.add(2);
        test.clear();
        assertEquals(true,test.isEmpty());

    }
}