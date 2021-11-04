import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseControllerTest {
    CourseCatalogue cc;

    CourseControllerTest() {
        this.cc = new CourseCatalogue();
    }

    @Test
    void addCourse() {
        cc.addCourse("CMPU20352", "Mon 13:30-17:30"); //add a course
        assertEquals(cc.courseCatalogue.size(), 1);
        cc.addCourse("BIOC356", "Tuesday 14:30-17:30"); //add a course
        assertEquals(cc.courseCatalogue.size(), 2);
    }

    @Test
    void removeCourse() {
        cc.addCourse("CMPU20352", "Mon 13:30-17:30"); //add a course
        cc.addCourse("BIOC356", "Tuesday 14:30-17:30"); //add a course
        cc.removeCourse("CMPU20352"); //remove the Course
        assertEquals(cc.courseCatalogue.size(), 1);
        cc.removeCourse("CMPU20352"); //class should already be removed
        assertEquals(cc.courseCatalogue.size(), 1);
        cc.removeCourse("BIOC356"); //remove the Course
        assertEquals(cc.courseCatalogue.size(), 0);
    }

    @Test
    void returnCourseList() {
        cc.addCourse("CMPU20352", "Mon 13:30-17:30"); //add a course
        cc.addCourse("BIOC356", "Tuesday 14:30-17:30"); //add a course
        String[] expected = new String[]{"CMPU20352", "BIOC356"};
        assertArrayEquals(cc.returnCourseList().toArray(), expected);
    }
}