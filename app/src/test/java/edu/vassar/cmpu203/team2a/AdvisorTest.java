package edu.vassar.cmpu203.team2a;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import edu.vassar.cmpu203.team2a.model.Advisor;

class AdvisorTest {

    Advisor ac;
    AdvisorTest() {
        this.ac = new Advisor();
    }

    @Test
    void addAdvisee() {
        ac.addAdvisee("junjie", 999516821, 2020,null, "Marc Smith", "CMPU");
        ac.addAdvisee("jun", 999516820, 2021,null,"Marc Smith", "CMPU");
        assertEquals(ac.size(), 2);
        ac.addAdvisee("xyz", 99516820, 2021,null,"Marc Smith","CMPU");
        assertEquals(ac.size(), 2); //Should not add an unusual ID
        ac.addAdvisee("xyz", 999516820, 20201, null,"Marc Smith","CMPU");
        assertEquals(ac.size(), 2); //Should not add an unusual year
    }

    @org.junit.jupiter.api.Test
    void deleteAdvisee() {
        ac.addAdvisee("junjie", 999516821, 2020,null,"Marc Smith","CMPU");
        ac.addAdvisee("jun", 999516820, 2021,null,"Marc Smith","CMPU");
        ac.deleteAdvisee(999526411); //jie is not in the list
        assertEquals(ac.size(),2); // nothing is supposed to be deleted
        ac.deleteAdvisee(999516820);
        assertEquals(ac.size(), 1); // deletion worked
    }

    /*not sure how to do this without making advisee class public
    @org.junit.jupiter.api.Test
    void returnAdviseeList() {
        ac.addAdvisee("junjie", 999516821, 2020, null,"Marc Smith","CMPU");
        ac.addAdvisee("jun", 999516820, 2021, null,"Marc Smith","CMPU");
        String[] expected = new String[]{"jun-999516820", "junjie-999516821"};
        assertArrayEquals(ac.returnAdviseeList().toArray(), expected);

    }
    */



    @Test
    void returnAdviseeIds() {
        ac.addAdvisee("junjie", 999516821, 2020, null,"Marc Smith","CMPU");
        ac.addAdvisee("jun", 999516820, 2021, null,"Marc Smith","CMPU");
        Integer[] expected = new Integer[]{999516821, 999516820};
        assertArrayEquals(ac.returnAdviseeIds().toArray(new Integer[0]), expected);
    }

    @Test
    void getAdviseeID() {
        ac.addAdvisee("junjie", 999516821, 2020,null, "Marc Smith", "CMPU");
        assertEquals(ac.getAdviseeID("junjie"), 999516821);
    }
}

