import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class AdviseeControllerTest {

    AdviseeController ac;
    AdviseeController aa;

    AdviseeControllerTest() {
        this.ac = new AdviseeController();
        this.aa = new AdviseeController();
    }

    @org.junit.jupiter.api.Test
    void addAdvisee() {
        ac.addAdvisee("junjie", 999516821, 2020);
        ac.addAdvisee("jun", 999516820, 2021);
        assertEquals(ac.advisees.size(), 2);
        ac.addAdvisee("xyz", 99516820, 2021);
        assertEquals(ac.advisees.size(), 2); //Should not add an unusual ID
        ac.addAdvisee("xyz", 999516820, 20201);
        assertEquals(ac.advisees.size(), 2); //Should not add an unusual year
    }

    @org.junit.jupiter.api.Test
    void deleteAdvisee() {
        ac.addAdvisee("junjie", 999516821, 2020);
        ac.addAdvisee("jun", 999516820, 2021);
        ac.deleteAdvisee("jie"); //jie is not in the list
        assertEquals(ac.advisees.size(), 2); // nothing is supposed to be deleted
        ac.deleteAdvisee("jun");
        assertEquals(ac.advisees.size(), 1); // deletion worked
    }

    @org.junit.jupiter.api.Test
    void returnAdviseeList() {
        aa.addAdvisee("junjie", 999516821, 2020);
        ac.addAdvisee("junjie", 999516821, 2020);
        ac.addAdvisee("jun", 999516820, 2021);
        assertNotEquals(ac.returnAdviseeList(),aa.returnAdviseeList()); //aa set is missing jun
        aa.addAdvisee("jun", 999516821, 2020);
        assertEquals(ac.returnAdviseeList(),aa.returnAdviseeList()); //aa set should now have jun and junjie like ac
        aa.deleteAdvisee("jun");
        aa.addAdvisee("jun", 999516820, 2020);
        assertEquals(ac.returnAdviseeList(),aa.returnAdviseeList()); //They have the same names, but are different people
        // need to fix the one test above

    }
}