package edu.vassar.cmpu203.team2a;

import edu.vassar.cmpu203.team2a.model.Advisor;

class AdvisorTest {

    Advisor ac;
    AdvisorTest() {
        this.ac = new Advisor();
    }

    /*@Test
    void addAdvisee() {
        ac.addAdvisee("junjie", 999516821, 2020,null, "Marc Smith");
        ac.addAdvisee("jun", 999516820, 2021,null,"Marc Smith");
        assertEquals(ac.size(), 2);
        ac.addAdvisee("xyz", 99516820, 2021,null,"Marc Smith");
        assertEquals(ac.size(), 2); //Should not add an unusual ID
        ac.addAdvisee("xyz", 999516820, 20201, null,"Marc Smith");
        assertEquals(ac.size(), 2); //Should not add an unusual year
    }

    @org.junit.jupiter.api.Test
    void deleteAdvisee() {
        ac.addAdvisee("junjie", 999516821, 2020,null,"Marc Smith");
        ac.addAdvisee("jun", 999516820, 2021,null,"Marc Smith");
        ac.deleteAdvisee(999526411); //jie is not in the list
        assertEquals(ac.size(),2); // nothing is supposed to be deleted
        ac.deleteAdvisee(999516820);
        assertEquals(ac.size(), 1); // deletion worked
    }

    @org.junit.jupiter.api.Test
    void returnAdviseeList() {
        ac.addAdvisee("junjie", 999516821, 2020, null,"Marc Smith");
        ac.addAdvisee("jun", 999516820, 2021, null,"Marc Smith");
        String[] expected = new String[]{"jun-999516820", "junjie-999516821"};
        assertArrayEquals(ac.returnAdviseeList().toArray(), expected);

    }*/
}