package edu.vassar.cmpu203.team2a;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;

import edu.vassar.cmpu203.team2a.model.Course;
import edu.vassar.cmpu203.team2a.model.Major;

class MajorTest {


    /**
     * Testing that createPool returns true when passing a string
     */
    @Test
    void createPool() {
        Major m = new Major();
        assertTrue(m.createPool("100lvl"));
    }


    /**
     * Testing that we can add a course to a pool
     */
    @Test
    void addCourse() {
        Major m = new Major();
        ArrayList<Course> l = new ArrayList<>();
        Course c = new Course ("CMPU11122","Monday530",l);
        m.createPool("100lvl");
        assertTrue(m.addCourse(c, "100lvl"));
    }

    /**
     * Testing that we can set the number of required course from a pool
     */
    @Test
    void setRequiredPoolCourses() {
        Major m = new Major();
        ArrayList<Course> l = new ArrayList<>();
        Course c = new Course ("CMPU11122","Monday530",l);
        m.createPool("100lvl");
        m.setRequiredPoolCourses(10, "100lvl");
        assertEquals(m.getMajor().get("100lvl").getNumOfRequiredCourses() , 10);
    }

    /** Testing that we can add a course, then remove it
    * Also testing that we can not remove a course if the course is not in the pool
    * or if the pool is not in the major
     * */
    @Test
    void removeCourse() {
        Major m = new Major();
        ArrayList<Course> l = new ArrayList<>();
        Course c = new Course ("CMPU11122","Monday530",l);
        Course d = new Course ("CMPU22122","Monday430",l);
        m.createPool("100lvl");
        m.addCourse(c, "100lvl");
        assertFalse(m.removeCourse(c, "200lvl"));
        assertFalse(m.removeCourse(d, "100lvl"));
        assertTrue(m.removeCourse(c,"100lvl"));

    }
}
