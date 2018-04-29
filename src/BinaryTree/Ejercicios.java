package BinaryTree;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Ejercicios<T> {
    public static int weight(BinaryTree tree){
        if(tree.isEmpty())
            return 0;
        else return 1 + weight(tree.getRight()) + weight(tree.getLeft());
    }
    public static int height(BinaryTree tree){
        if(tree.isEmpty())
            return 0;
        if(isLeaf(tree))
            return 1;
        return Math.max(1+height(tree.getRight()),1+height(tree.getLeft()));
    }

    public static boolean isLeaf(BinaryTree tree){
        return tree.getRight().isEmpty() && tree.getLeft().isEmpty();
    }
    public static int leaves(BinaryTree tree){
        if(tree.isEmpty()) // solo deberia suceder si me dan un arbol vacio como argumento
            return 0;
        if(isLeaf(tree))
            return 1;
        return leaves(tree.getLeft()) + leaves(tree.getRight());
    }
    public static int count(Object elem, BinaryTree tree){
        if(tree.isEmpty())
            return 0;
        if(elem.equals(tree.getRoot()))
            return 1 + count(elem,tree.getRight()) + count(elem,tree.getLeft());
        return count(elem,tree.getRight()) + count(elem,tree.getLeft());
    }
    public static int elementsInLevel(BinaryTree tree, int level){
        if(tree.isEmpty())
            return 0;
        if(level == 1)
            return 1;
        return elementsInLevel(tree.getLeft(),level-1) + elementsInLevel(tree.getRight(),level-1);
    }

    public static void printPostOrder(BinaryTree tree){
        if(tree.isEmpty())
            return;
        printPostOrder(tree.getLeft());
        printPostOrder(tree.getRight());
        System.out.print(tree.getRoot());

    }
    public static void printPreOrder(BinaryTree tree){
        if(tree.isEmpty())
            return;
        System.out.print(tree.getRoot());
        printPreOrder(tree.getLeft());
        printPreOrder(tree.getRight());
    }

    public static void printInOrder(BinaryTree tree){
        if(tree.isEmpty())
            return;
        printInOrder(tree.getLeft());
        System.out.print(tree.getRoot());
        printInOrder(tree.getRight());
    }
    public static void printLevel(BinaryTree tree, int level){
        if(tree.isEmpty())
            return;
        if(level == 1)
            System.out.print(tree.getRoot());
        printLevel(tree.getLeft(),level-1);
        printLevel(tree.getRight(),level-1);
    }
    public static void printByLevel(BinaryTree tree){
        int h = height(tree);
        for(int i=1;i<=h;i++){
            printLevel(tree,i);
        }
    }
    //a) Se dispone de un árbol binario de elementos de tipo entero. Escribir métodos que calculen:
    //i) la suma de sus elementos.
    public static int sum(BinaryTree<Integer> t){
        if(t.isEmpty())
            return 0;
        return t.getRoot() + sum(t.getRight()) + sum(t.getLeft());
    }
    //ii) la suma de sus elementos que son múltiplos de 3.
    public static int sum2(BinaryTree<Integer> t){
        if(t.isEmpty())
            return 0;
        int root = t.getRoot();
        return root % 3 == 0 ? root + sum2(t.getLeft()) + sum2(t.getRight()) : sum2(t.getRight())+sum2(t.getLeft());
    }
    public static boolean equals(BinaryTree t1,BinaryTree t2){
        if(t1.isEmpty() || t2.isEmpty())
            return t1.isEmpty() == t2.isEmpty();
        if(!t1.getRoot().equals(t2.getRoot()))
            return false;
        return equals(t1.getLeft(),t2.getLeft()) && equals(t1.getRight(),t2.getRight());
    }
    public static boolean isomorph(BinaryTree t1, BinaryTree t2){
        if(t1.isEmpty() != t2.isEmpty())
            return false;
        if(t1.isEmpty())
            return true;
        return isomorph(t1.getRight(),t2.getRight()) && isomorph(t1.getLeft(),t2.getLeft());
    }
    public static boolean similar(BinaryTree t1, BinaryTree t2){//retorna verdadero si los dos arboles sin elementos repetidos son semejantes
        if(t1.isEmpty())
            return true;
        if(count(t1.getRoot(),t2) == 0)
            return false;
        return similar(t1.getRight(),t2) && similar(t1.getLeft(),t2);
    }
    public static boolean complete(BinaryTree t){
        if(t.isEmpty())//solo sucede cuando el argumento es vacio
            return false;
        if(isLeaf(t))
            return true;
        return complete(t.getLeft()) && complete(t.getRight());
    }
    public static boolean full(BinaryTree t){
        int height = height(t);
        return (elementsInLevel(t,height) == Math.pow(2,height-1));
    }
    public static boolean stable(BinaryTree<Integer> t){
        if(t.isEmpty() || isLeaf(t))
            return true;
        if(t.getLeft().isEmpty())
            if(t.getRight().getRoot() > t.getRoot())
                return false;
        if(t.getRight().isEmpty())
            if(t.getLeft().getRoot() > t.getRoot())
                return false;
        return stable(t.getRight()) && stable(t.getLeft());
    }
    public static boolean occurs(BinaryTree t1,BinaryTree t2){
        if(t2.isEmpty())
            return true;
        if(t1.isEmpty())
            return false;
        if(t1.getRoot() != t2.getRoot())
            return occurs(t1.getLeft(), t2) || occurs(t1.getRight(),t2);
        if(occursAux(t1,t2))
            return true;
        return occurs(t1.getLeft(), t2) || occurs(t1.getRight(),t2);

    }

    private static boolean occursAux(BinaryTree t1, BinaryTree t2) {
        //retorna verdadero si t2 esta contenido en t1 a partir de la raiz t1 y t2
        // es basicamente un equals que retorna verdadero ademas de cuando son iguales cuando t.odo t2 esta en t1
        if(t1.isEmpty())
            return t2.isEmpty();
        if(t2.isEmpty())
            return true;
        if(!t1.getRoot().equals(t2.getRoot()))
            return false;
        return occursAux(t1.getRight(),t2.getRight()) && occursAux(t1.getLeft(),t2.getLeft());
    }
    public static void showFrontier(BinaryTree t){
        if(t.isEmpty())
            return;
        if(isLeaf(t)) {
            System.out.print(t.getRoot().toString() + " ");
            return;
        }
        showFrontier(t.getLeft());
        showFrontier(t.getRight());
    }
    public static ArrayList frontier(BinaryTree t){
        ArrayList res = new ArrayList();
        frontierAux(t,res);
        return res;
    }
    @SuppressWarnings("unchecked")
    public static void frontierAux(BinaryTree t, ArrayList a){
        if(t.isEmpty())
            return;
        if(isLeaf(t)) {
            a.add(t.getRoot());
            return;
        }
        frontierAux(t.getLeft(),a);
        frontierAux(t.getRight(),a);
    }
    public static void saveToDisk(BinaryTree t, String filename){
        try {
            OutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(t);
            out.close();
            file.close();
        } catch (java.io.IOException e) {
            System.out.println("IO ERROR");
        }
    }
    public static BinaryTree recoverFromDisk(String filename){
        BinaryTree t = null;
        try
        {
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
            t = (BinaryTree)in.readObject();
            in.close();
            file.close();
        }
        catch(IOException ex)
        {
            System.out.println("IO ERROR");
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Invalid class");
        }
        return t;
    }
    public static void main(String[] args) {
        BinaryTree<Integer> test = new BinaryTree<Integer>(
                10,new BinaryTree<>(20),new BinaryTree<>(30,new BinaryTree<>(),new BinaryTree<>(3)));
        System.out.println(sum(test)); // 10 + 20 + 30 + 3 = 63
        System.out.println(sum2(test));// 33
        BinaryTree<Integer> equal = new BinaryTree<Integer>(
                10,new BinaryTree<>(20),new BinaryTree<>(30,new BinaryTree<>(),new BinaryTree<>(3)));
        System.out.println(equals(test,equal));//true
        BinaryTree<Integer> isomorph = new BinaryTree<Integer>(
                150,new BinaryTree<>(203),new BinaryTree<>(310,new BinaryTree<>(),new BinaryTree<>(33)));
        System.out.println(isomorph(isomorph,test));//true
        System.out.println(equals(isomorph,test));//false
        BinaryTree<Integer> semejante =  new BinaryTree<Integer>(
                30,new BinaryTree<>(3),new BinaryTree<>(10,new BinaryTree<>(),new BinaryTree<>(20)));
        System.out.println(similar(semejante,test));//true
        BinaryTree<Integer> test2 = new BinaryTree<Integer>(10,new BinaryTree<Integer>(5),new BinaryTree<Integer>(4));
        System.out.println(complete(test2));//true
        System.out.println(stable(test2));//true
        System.out.println(full(test2));//true
        showFrontier(test);// 20 3
        ArrayList arrayList = frontier(test);
       System.out.println(arrayList.toString());// [20, 3]
        String filename = "testTree.ser";
        saveToDisk(test, filename);
        BinaryTree t = recoverFromDisk(filename);
        // Arbol de prueba
        //      10
        //    20  30
        //          3
        printInOrder(t);//20 10 30 3
        System.out.println();
        printByLevel(t);//10 20 30 3
        System.out.println();
        printPreOrder(t);//10 20 30 3
        System.out.println();
        printPostOrder(t); //20 3 30 10

    }
}
