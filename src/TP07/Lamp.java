package TP07;

public class Lamp implements Comparable<Lamp>{
    private String code;
    private int watts;
    private String type;
    private int quantity;
    /**
     * Construct a lamp object
     * @param code product code, MUST be 5 characters long
     * @param watts integer
     * @param type lamp type, at most 10 characters long
     * @param quantity the amount of lamps with this code in stock
     */
    public Lamp(String code, int watts, String type, int quantity) throws InvalidCodeException, InvalidTypeException {
        if(code == null || code.length() != 5)
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
                "El stock de la lampara es de "+ quantity +" unidades.";
    }
    /**
     * compare's lamps based on their codes comparing the ascii value of the characters
     * note that this doesn't mean that it uses alphabetical order as in ascii the code for
     * a (97) is greater than the code for B (66)
     * @param lamp lamp to compare to
     * @return 0 if the lamp's codes are equal, < 0 if lamp2's code is greater than lamp 1's code and > 0 if lamp1's code is greater than lamp2's code
     */
    @Override
    public int compareTo(Lamp lamp) {
        return this.code.compareTo(lamp.getCode());
    }
}
