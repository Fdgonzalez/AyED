package BinarySearchTree;

import org.junit.Test;

import static org.junit.Assert.*;

public class LampStockComparatorTest {

    @Test
    public void compare() throws InvalidCodeException, InvalidTypeException {
        LampStock lamp1 = new LampStock("aaaaa",100,"tipo 1",10);
        LampStock lamp2 = new LampStock("aaaab",100,"tipo 2", 12);
        assertTrue((new LampComparator()).compare(lamp1,lamp2) < 0);
    }
}