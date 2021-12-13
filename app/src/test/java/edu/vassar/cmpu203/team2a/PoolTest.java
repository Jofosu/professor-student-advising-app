package edu.vassar.cmpu203.team2a;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;

import edu.vassar.cmpu203.team2a.model.Course;
import edu.vassar.cmpu203.team2a.model.Major;
import edu.vassar.cmpu203.team2a.model.Pool;

public class PoolTest {

    @Test void addPoolCourseAndRemovePoolCourse(){
        Major m = new Major();
        Course c = new Course("CMPU20352", "Mon 13:30-17:30", null);
        m.createPool("100lvl");
        m.getAPool("100lvl").addPoolCourse(c);
        ArrayList<Course> carray = new ArrayList<Course>();
        carray = m.getAPool("100lvl").getpoolList();
        assertEquals(carray.size(), 1);
        m.getAPool("100lvl").removePoolCourse(c);
        carray = m.getAPool("100lvl").getpoolList();
        assertEquals(carray.size(), 0);

    }



}
