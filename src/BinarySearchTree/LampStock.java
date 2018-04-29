package BinarySearchTree;

public class LampStock{
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
    public LampStock(String code, int watts, String type, int quantity) throws InvalidCodeException, InvalidTypeException {
        if(code.length() != 5)
            throw new InvalidCodeException();
        this.code = code;
        this.watts = watts;
        if(type.length() > 10)
            throw new InvalidTypeException();
        this.type = type;
        this.quantity = quantity;
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
    @Override
    public String toString(){
        return "Codigo de lampara " + code + ":\n" +
                "La lampara es de " + watts + " Watts.\n" +
                "La lampara es de tipo " + type + ".\n" +
                "El stock de la lampara es de "+ quantity +" unidades.\n";
    }
}
