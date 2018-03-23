package Lists;

import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;

public class SortedSetMerger<T> {
    public SortedSet<T> merge(SortedSet<T> s1, SortedSet<T> s2) throws InvalidComparatorException {
        Comparator<T> comparator;
        if((comparator = (Comparator<T>) s1.comparator()) == null)
            throw new InvalidComparatorException();
        SinglyLinkedListSortedSet<T> result = new SinglyLinkedListSortedSet<T>(comparator);
        Iterator<T> it1= s1.iterator();
        Iterator<T> it2 = s2.iterator();
        while(it1.hasNext() && it2.hasNext()){
            Iterator<T> aux1 = s1.iterator();
            Iterator<T> aux2 = s2.iterator();
            int comparison = comparator.compare(aux1.next(),aux2.next());
            if(comparison <0)
                result.add(it1.next());
            else
                result.add(it2.next());
        }
        while(it1.hasNext())
            result.add(it1.next());
        while (it2.hasNext())
            result.add(it2.next());
        return result;
    }
}
