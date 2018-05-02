package TP07;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner;
    private static LampStockBST stockBST;
    public static void main(String[] args) throws InvalidCodeException, InvalidTypeException {
        scanner = new Scanner(System.in);
        //Uso line endings como delimitadores en vez del default que es espacio en blanco para poder tener tipos de
        //mas de una palabra, el patron usado funciona para line endings CR (/r), LF(/n) o CRLF(/r/n)
        scanner.useDelimiter(";|\r?\n|\r");
        //Armo el arbol a partir de una lista
        List<Lamp> list = new LinkedList<>();
        Lamp a = new Lamp("00003",110, "Tipo A",20);
        Lamp b = new Lamp("00002",110, "Tipo A",20);
        Lamp c = new Lamp("00004",110, "Tipo A",20);
        Lamp d = new Lamp("00001",110, "Tipo A",20);
        Lamp e = new Lamp("00005",110, "Tipo A",20);
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        stockBST = LampStockBST.newFromList(list);
        int menu;
        while((menu = menu()) != 5) {
            switch (menu) {
                case 1:
                    stockBST.add(new Lamp(newCode(),newWatts(),newType(),newStock()));
                    break;
                case 2:
                    stockBST.remove(newCode());
                    break;
                case 3:
                    modify();
                    break;
                case 4:
                    stockBST.printInformation();
                    break;
            }
        }

    }

    private static void modify() {
        int menu;
        while ((menu = modifyMenu()) != 4){
            switch (menu){
                case 1: stockBST.modifyStock(newCode(),newStock()); break;
                case 2: stockBST.modifyType(newCode(),newType()); break;
                case 3: stockBST.modifyWatts(newCode(),newWatts()); break;
            }
        }
    }

    private static int modifyMenu(){
        System.out.println("Modificar: ");
        System.out.println("1. Modificar Stock");
        System.out.println("2. Modificar tipo");
        System.out.println("3. Modificar watts");
        System.out.println("4. Volver al menu");
        int c = scanner.nextInt();
        if(c > 4 || c < 1)
            return modifyMenu();
        return c;
    }
    private static int menu(){
        System.out.println("Stock de Lamparas: ");
        System.out.println("1. Dar de alta un nuevo producto");
        System.out.println("2. Dar de baja un producto");
        System.out.println("3. Modificar un producto");
        System.out.println("4. Imprimir un informe ordenado por codigo de producto");
        System.out.println("5. Salir");
        int c = scanner.nextInt();
        if(c >5 || c < 1)
            return menu();
        return c;
    }
    private static int newStock() {
        System.out.println("Ingrese la cantidad en stock: ");
        int temp;
        try {
            temp = scanner.nextInt();
        } catch(InputMismatchException e){
            System.out.println("El stock solo puede ser un numero entero");
            scanner.nextLine();
            return newStock();
        }
        if(temp < 0) {
            System.out.println("El stock no puede ser negativo");
            return newStock();
        }
        return temp;
    }

    private static String newType() {
        System.out.println("Ingrese el tipo de la lampara: ");
        String temp = scanner.next();
        if(temp.length() > 10) {
            System.out.println("El tipo de lampara no puede tener mas de diez caracteres");
            return newType();
        }
        return temp;
    }

    private static int newWatts() {
        System.out.println("Ingrese los watts de la lampara: ");
        int temp;
        try {
            temp = scanner.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Los watts solo pueden ser un numero entero");
            scanner.nextLine();
            return newWatts();
        }
        if(temp <= 0){
            System.out.println("Los watts no pueden ser negativos o cero");
            return newWatts();
        }

        return temp;
    }

    private static String newCode() {
        System.out.println("Ingrese el codigo de producto: ");
        String temp = scanner.next();
        if(temp.length() != 5) {
            System.out.println("Codigo invalido");
            return newCode();
        }
        return temp;
    }
}
