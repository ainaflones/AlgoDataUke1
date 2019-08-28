import org.junit.Test;

import static org.junit.Assert.*;

public class TabellTest {

    @org.junit.Test
    public void turTabell() {

        int [] a = {1,2,7,3,9,13,25,57,32,45,89,33,21};


        assertArrayEquals(new int[]{89,57},Tabell.turTabell(a));

    }

    @Test
    public void kopier() {

        int a [] = {2,3,4,5};
        int b [] = new int[8];
        int c [] = {0,0,0,0,2,3,4,5};



    }
}