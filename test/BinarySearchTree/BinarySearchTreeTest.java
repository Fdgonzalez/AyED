package BinarySearchTree;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {
    @Test
    public void getRoot() throws ElementAlreadyInTreeException {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(Integer::compareTo);
        bst.insert(10);
        assertEquals(10,(int) bst.getRoot());
    }

    @Test
    public void getLeftAndgetRight() throws ElementAlreadyInTreeException {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(Integer::compareTo);
        bst.insert(10);
        bst.insert(14); //should be right element
        bst.insert(9); //shoud be left element
        assertEquals(14 ,(int) bst.getRight().getRoot());
        assertEquals(9, (int) bst.getLeft().getRoot());
    }

    @Test
    public void getMin() throws ElementAlreadyInTreeException {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(Integer::compareTo);
        bst.insert(10);
        bst.insert(14);
        bst.insert(9);
        bst.insert(4);
        bst.insert(3);
        bst.insert(1);
        assertEquals(1,(int) bst.getMin());
    }

    @Test
    public void getMax() throws ElementAlreadyInTreeException {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(Integer::compareTo);
        bst.insert(10);
        bst.insert(14);
        bst.insert(9);
        bst.insert(4);
        bst.insert(3);
        bst.insert(1);
        assertEquals(14,(int) bst.getMax());
    }

    @Test
    public void contains() throws ElementAlreadyInTreeException {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(Integer::compareTo);
        bst.insert(10);
        bst.insert(14);
        bst.insert(9);
        bst.insert(4);
        bst.insert(3);
        bst.insert(1);
        assertTrue(bst.contains(3));
    }

    @Test
    public void search() throws ElementAlreadyInTreeException {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(Integer::compareTo);
        Integer elem = 14;
        bst.insert(10);
        bst.insert(elem);
        bst.insert(9);
        bst.insert(4);
        bst.insert(3);
        bst.insert(1);
        assertEquals(elem,bst.search(elem));
    }

    @Test
    public void delete() throws ElementAlreadyInTreeException {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(Integer::compareTo);
        bst.insert(10);
        bst.insert(14);
        bst.insert(9);
        bst.insert(4);
        bst.insert(3);
        bst.insert(1);
        assertTrue(bst.contains(3));
        bst.delete(3);
        assertFalse(bst.contains(3));

    }
}