package BinarySearchTree;

import org.junit.Test;

import static org.junit.Assert.*;

public class LampComparatorByCodeTest {

    @Test
    public void compare() throws InvalidCodeException, InvalidTypeException {
        Lamp lamp1 = new Lamp("aaaaa",100,"tipo 1",10);
        Lamp lamp2 = new Lamp("aaaab",100,"tipo 2", 12);
        assertTrue((new LampComparatorByCode()).compare(lamp1,lamp2) < 0);
    }
}