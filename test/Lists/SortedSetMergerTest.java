package Lists;

import org.junit.Test;

import java.util.SortedSet;

import static org.junit.Assert.*;

public class SortedSetMergerTest {

    @Test
    public void merge() throws InvalidComparatorException {
        SinglyLinkedListSortedSet<Integer> l1 = new SinglyLinkedListSortedSet<>(Integer::compareTo);
        SinglyLinkedListSortedSet<Integer> l2 = new SinglyLinkedListSortedSet<>(Integer::compareTo);
        l1.add(1);l1.add(2);l1.add(3);l1.add(4);
        l2.add(5);l2.add(6);l2.add(7);l2.add(8);
        SortedSetMerger<Integer> merger = new SortedSetMerger<>();
        SortedSet<Integer> result = merger.merge(l1,l2);
        for(Integer i:result){
            System.out.println(i);
        }
    }
}