package BinarySearchTree;

import java.util.NoSuchElementException;

/**
 * <h1>LampStockBST</h1>
 * keeps track of Lamp Stock using a binary search tree internally
 * @author Facundo Gonzalez
 **/
public class LampStockBST {
    private BinarySearchTree<LampStock> tree;
    public LampStockBST(){
        tree = new BinarySearchTree<>(new LampComparator());
    }
    public void add(LampStock l){
        try {
            tree.insert(l);
        } catch (ElementAlreadyInTreeException e) {
            System.out.println("El stock de la lampara ingresada ya se encuentra en el registro");
            System.out.println("Para modificarlo use el metodo modifiy() ");
        }
    }
    public void modifyStock(String lampCode,int newStock){
        try {
            search(lampCode).setStock(newStock);
        } catch (InvalidCodeException e) {
            System.out.println("El codigo ingresado no es valido");
        } catch(NoSuchElementException e){
            System.out.println("El elemento no fue encontrado en el regitro");
        }
    }
    public void modifyWatts(String lampCode,int watts){
        try {
            search(lampCode).setWatts(watts);
        } catch (InvalidCodeException e) {
            System.out.println("El codigo ingresado no es valido");
        } catch(NoSuchElementException e){
            System.out.println("El elemento no fue encontrado en el regitro");
        }
    }
    public void modifyType(String lampCode,String type){
        try {
            search(lampCode).setType(type);
        } catch (InvalidCodeException e) {
            System.out.println("El codigo ingresado no es valido");
        } catch(NoSuchElementException e){
            System.out.println("El elemento no fue encontrado en el regitro");
        } catch (InvalidTypeException e) {
            System.out.println("El tipo ingresado es muy largo");
        }
    }

    /**
     * prints all entries in the tree ordered by lamp code
     */
    public void printOrderedByCode(){
        tree.printInOrder();
    }

    public LampStock search(String lampCode) throws InvalidCodeException {
        LampStock temp;
        try {
            //Crea un objeto que solo se usa para buscar el objeto guardado con el mismo codigo
            //ya que el arbol esta ordenado por codigo los demas atributos no importan para la busqueda
            temp = new LampStock(lampCode,0,"temp",0);
        } catch (InvalidTypeException e) {
            e.printStackTrace(); // solo puede suceder si esta mal implementado el constructor
            temp = null;
        }
        return tree.search(temp);
    }
}
