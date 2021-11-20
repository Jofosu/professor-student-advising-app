package edu.vassar.cmpu203.team2a;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import edu.vassar.cmpu203.team2a.model.Course;

import edu.vassar.cmpu203.team2a.model.Prerequisite;

class PrerequisiteTest {

    LinkedList l = new LinkedList();
    Course cs101 = new Course ("CMPU101","Monday530",l);
    Course cs102 = new Course ("CMPU102","Monday430",l);
    Course cs203 = new Course ("CMPU203","Monday330",l);
    Prerequisite p = new Prerequisite();

    @Test
    void addPrerequisitesTest() {
        p.addPrerequisites(cs203, cs101);
        Course[] expected = new Course[]{cs101};
        assertArrayEquals(cs203.getPrerequisites().toArray(), expected);
    }

}