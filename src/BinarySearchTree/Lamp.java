package BinarySearchTree;

public class Lamp {
    private String code;
    private int watts;
    private String type;
    private int quantity;
    /**
     * Construct a lamp object
     * @param code product code, MUST be 5 characters long
     * @param watts integer
     * @param type lamp type, at most 10 characters long
     * @param quantity the ammount of lamps of this type in stock
     */
    public Lamp(String code, int watts, String type, int quantity) throws InvalidCodeException, InvalidTypeException {
        if(code.length() != 5)
            throw new InvalidCodeException();
        this.code = code;
        this.watts = watts;
        if(type.length() > 10)
            throw new InvalidTypeException();
        this.type = type;
        this.quantity = quantity;
    }

    /**
     * Construct a Lamp that only has a code to use for searching for other Lamps with the same code
     * @return
     */
    public Lamp(String code) throws InvalidCodeException {
        if(code.length() != 5)
            throw new InvalidCodeException();
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public int getStock() {
        return quantity;
    }
    public String getType(){
        return type;
    }
    public int getWatts(){
        return watts;
    }

    public void setStock(int newStock) {
        this.quantity = newStock;
    }


    public void setWatts(int watts) {
        this.watts = watts;
    }

    public void setType(String type) throws InvalidTypeException {
        if(type.length()>10)
            throw new InvalidTypeException();
        this.type = type;
    }

    /**
     * Returns this lamp's information on a String
     */
    @Override
    public String toString(){
        return "Codigo de lampara " + code + ":\n" +
                "La lampara es de " + watts + " Watts.\n" +
                "La lampara es de tipo " + type + ".\n" +
                "El stock de la lampara es de "+ quantity +" unidades.\n";
    }
}
