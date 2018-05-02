package TP07;

import java.util.NoSuchElementException;

/**
 * LampStockBST
 * keeps track of Lamp Stock using a binary search tree internally
 * @author Facundo Gonzalez
 **/
public class LampStockBST extends BinarySearchTree<Lamp>{

    /**
     * Constructs an empty binary search tree using the Lamp comparator
     *
     */
    public LampStockBST() {
        super(new LampComparatorByCode());
    }

    public void add(Lamp l){
        try {
            insert(l);
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
    public void printInformation(){ printInOrder();}
    /**
     * Returns the Lamp stored in the tree with the code given
     * @param lampCode
     * @return the lamp with the code given
     * @throws InvalidCodeException if the code to search is not five characters in length
     * @throws NoSuchElementException if the Lamp is not in the tree
     */
    public Lamp search(String lampCode) throws InvalidCodeException {
        Lamp temp;
        //Creates an object with only a code to search the tree, as this tree is ordered by code the other attributes don't matter for the search
        temp = new Lamp(lampCode);
        return search(temp);
    }
}
