package TP07;

public class DoubleNode <T>{
    T value;
    DoubleNode <T> right, left;
    public DoubleNode(T o){
        value = o;
    }

    public DoubleNode(T o, DoubleNode<T> left, DoubleNode<T> right){
        value = o;
        this.right = right;
        this.left = left;
    }
}