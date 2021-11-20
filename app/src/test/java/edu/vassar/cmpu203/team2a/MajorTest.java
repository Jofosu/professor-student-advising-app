package edu.vassar.cmpu203.team2a;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import edu.vassar.cmpu203.team2a.model.Course;
import edu.vassar.cmpu203.team2a.model.Major;

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
        m.createPool("100lvl");
        assertTrue(m.addCourse(c, "100lvl"));
    }

    @Test
    void setRequiredPoolCourses() {
        Major m = new Major();
        LinkedList l = new LinkedList();
        Course c = new Course ("CMPU11122","Monday530",l);
        m.createPool("100lvl");
        m.setRequiredPoolCourses(10, "100lvl");
        assertEquals(m.getMajor().get("100lvl").getNumReq() , 10);
    }

    @Test
    void removeCourse() {
        Major m = new Major();
        LinkedList l = new LinkedList();
        Course c = new Course ("CMPU11122","Monday530",l);
        Course d = new Course ("CMPU22122","Monday430",l);
        m.createPool("100lvl");
        m.addCourse(c, "100lvl");
        assertFalse(m.removeCourse(c, "200lvl"));
        assertFalse(m.removeCourse(d, "100lvl"));
        assertTrue(m.removeCourse(c,"100lvl"));

    }
}