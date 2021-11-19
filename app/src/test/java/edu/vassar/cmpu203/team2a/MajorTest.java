package edu.vassar.cmpu203.team2a;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import edu.vassar.cmpu203.team2a.model.Major;
import edu.vassar.cmpu203.team2a.model.Course;

class MajorTest {

    @Test
    void createPool() {
        Major m = new Major();
        assertTrue(m.createPool("100lvl"));
    }


    @Test
    void addCourse() {
        Major m = new Major();
        LinkedList l = new LinkedList();
        Course c = new Course ("CMPU11122","Monday530",l);
        assertTrue(m.addCourse(c, "100lvl"));
    }

    @Test
    void getMajor() {
        Major m = new Major();
        LinkedList l = new LinkedList();
        Course c = new Course ("CMPU10151","Monday530",l);
        Course d = new Course ("CMPU10251","Monday430",l);
        m.createPool("100lvl");
        m.addCourse(c, "100lvl");
        m.addCourse(d, "100lvl");
        Course[] expected = new Course[]{c, d};
        assertArrayEquals(m.getMajor().keySet().toArray(new Object[0]), expected);
    }

    @Test
    void setRequiredPoolCourses() {
    }

    @Test
    void removeCourse() {
    }
}