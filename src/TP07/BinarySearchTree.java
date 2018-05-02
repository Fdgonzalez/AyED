package TP07;

import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * <h1>Binary search tree</h1>
 * linked implementation of a binary search tree
 * the tree does not allow duplicate elements
 * @param <T> the object to store
 * @author Facundo Gonzalez
 */
public class BinarySearchTree<T>{
    private Comparator<T> comparator;
    private DoubleNode<T> root;

    /**
     * Constructs an empty binary search tree with the comparator given
     * @param comparator
     */
    public BinarySearchTree(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    /**
     * @return true if the tree contains no elements
     */
    public boolean isEmpty(){
        return root == null;
    }

    /**
     * @return the element at the tree's root
     * @throws NoSuchElementException if the tree is empty
     */
    public T getRoot(){
        if(this.isEmpty())
            throw new NoSuchElementException();
        return root.value;
    }
    /**
     * @return the tree's left child which is another tree
     * @throws NoSuchElementException if the tree is empty
     */
    public BinarySearchTree<T> getLeft(){
        if(this.isEmpty())
            throw new NoSuchElementException();
        BinarySearchTree<T> temp = new BinarySearchTree<T>(comparator);
        temp.root = root.left;
        return temp;
    }

    /**
     * @return the tree's right child which is another tree
     * @throws NoSuchElementException if the tree is empty
     */
    public BinarySearchTree<T> getRight(){
        if(this.isEmpty())
            throw new NoSuchElementException();
        BinarySearchTree<T> temp = new BinarySearchTree<T>(comparator);
        temp.root = root.right;
        return temp;
    }

    /**
     * @return the lowest element in the tree
     * @throws NoSuchElementException if the tree is empty
     */
    public T getMin(){
        if(this.isEmpty())
            throw new NoSuchElementException();
        return getMin(root);
    }

    /**
     * @return the highest element in the tree
     * @throws NoSuchElementException if the tree is empty
     */
    public T getMax(){
        if(this.isEmpty())
            throw new NoSuchElementException();
        return getMax(root);
    }

    /**
     * @param element the element to look for
     * @return true if element is in tree
     */

    public boolean contains(T element) {
        return contains(element, root);
    }
    /**
     * @param element the element to look for
     * @return the element found in the tree
     * @throws NoSuchElementException if the element is not in the tree
     */
    public T search(T element) throws NoSuchElementException{
        return search(element, root);
    }
    /** Adds an element to the tree
     * @param element, the element to add to the tree
     * @throws ElementAlreadyInTreeException on duplicate element
     * **/
    public void insert(T element) throws ElementAlreadyInTreeException {
        root = insert(element, root);
    }

    /**
     * Deletes an element from the tree
     * @param element to delete
     * @throws NoSuchElementException if the element is not in the tree
     */
    public void delete(T element){
        root = delete(element,root);
    }

    /**
     * delete private implementation
     * Deletes an element from the tree recursively
     * @param element the element to delete
     * @param t the root of the current tree
     * @return the doubleNode of the tree with the element deleted
     * @throws NoSuchElementException if the element to delete is not present in the tree
     */
    private DoubleNode<T> delete(T element, DoubleNode<T> t) {
        if(t == null)
            throw new NoSuchElementException();
        int c = comparator.compare(element,t.value);
        if(c < 0){
            t.left = delete(element,t.left);
        }else if(c > 0){
            t.right = delete(element,t.right);
        }else {
            /*  to keep the tree as balanced as possible use the following strategy:
            *   when the node to delete has a left and a right child, move the highest (max) element of the
            *   left child to the node to be deleted.
            */
            if (t.right != null && t.left != null) {
                t.value = getMax(t.left); // the node to be deleted's value is now the left child's highest element
                t.left = deleteMax(t.left);//delete the left child's highest element because we already moved it
            }else if(t.left == null){
                t = t.right;
            }else{
                t = t.left;
            }
        }
        return t;
    }
    /**
     * deletes the highest element in the tree recursively
     * @param t the DoubleNode that is the root of the tree
     * @return the root of the tree with the element deleted
     * **/
    private DoubleNode<T> deleteMax(DoubleNode<T> t) {
        if(t.right != null)
            t.right = deleteMax(t.right);
        else
            t = t.left;// if the tree has no right child then it is the highest element
        //so to delete it, it's left child takes it's place
        return t;
    }

    private boolean contains(T element,DoubleNode<T> t){
        if(t == null) return false;
        int comparison = comparator.compare(t.value, element);
        if(comparison == 0) return true;
        else if(comparison < 0) return contains(element, t.right);
        else return contains(element, t.left);
    }

    private DoubleNode<T> insert(T element, DoubleNode<T> t) throws ElementAlreadyInTreeException {
        if(t == null) {
            t = new DoubleNode<>(element);
            return t;
        }
        int comparison = comparator.compare(t.value,element);
        if(comparison == 0)
            throw new ElementAlreadyInTreeException();
        else if(comparison > 0)
            t.left = insert(element,t.left);
        else
            t.right = insert(element,t.right);
        return t;
    }

    private T search(T element, DoubleNode<T> t) {
        if(t == null) throw new NoSuchElementException();
        int comparison = comparator.compare(t.value, element);
        if(comparison == 0) return t.value;
        if(comparison < 0) return search(element, t.right);
        else return search(element, t.left);
    }

    private T getMin(DoubleNode<T> t){
        if(t.left == null) return t.value;
        return getMin(t.left);
    }

    private T getMax(DoubleNode<T> t) {
        if(t.right == null)
            return t.value;
        return getMax(t.right);
    }
    public void printInOrder(){
        if(isEmpty())
            return;
        getLeft().printInOrder();
        System.out.println(getRoot());
        getRight().printInOrder();
    }
}
