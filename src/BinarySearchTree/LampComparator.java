package BinarySearchTree;

import java.util.Comparator;

public class LampComparator implements Comparator<LampStock> {

    /**
     * compare's lamps based on their codes comparing the ascii value of the characters
     * note that this doesn't mean that it uses alphabetical order as in ascii the code for
     * a (97) is greater than the code for B (66)
     * @param lamp
     * @param lamp2
     * @return 0 if the lamp's codes are equal, < 0 if lamp2's code is greater than lamp 1's code and > 0 if lamp1's code is greater than lamp2's code
     */
    @Override
    public int compare(LampStock lamp, LampStock lamp2) {
       return lamp.getCode().compareTo(lamp2.getCode());
    }
}
