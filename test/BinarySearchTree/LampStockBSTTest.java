package BinarySearchTree;

import org.junit.Test;

import static org.junit.Assert.*;

public class LampStockBSTTest {

    @Test
    public void modify() throws InvalidCodeException, InvalidTypeException {
        LampStockBST stock = new LampStockBST();
        stock.add(new LampStock("aaaaa",100,"Tipo A",10));
        stock.add(new LampStock("aaaab",110,"Tipo B",12));
        stock.add(new LampStock("aaaac",130,"Tipo C",14));
        assertEquals(10,stock.search("aaaaa").getStock());
        stock.modifyStock("aaaaa",5);
        assertEquals(5,stock.search("aaaaa").getStock());
        stock.modifyWatts("aaaab",220);
        assertEquals(220,stock.search("aaaab").getWatts());
        stock.modifyType("aaaac","Tipo H2");
        assertEquals("Tipo H2",stock.search("aaaac").getType());
    }

    @Test
    public void printOrderedByCode() throws InvalidCodeException, InvalidTypeException {
        LampStockBST stock = new LampStockBST();
        stock.add(new LampStock("00001",110,"Tipo B",12));
        stock.add(new LampStock("00000",100,"Tipo A",10));

        stock.printOrderedByCode();
    }
}