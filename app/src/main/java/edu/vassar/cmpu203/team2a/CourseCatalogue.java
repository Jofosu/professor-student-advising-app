package edu.vassar.cmpu203.team2a;

import java.util.HashMap;

import java.util.LinkedList;
import java.util.Set;

/**
 * Contains a HashMap collection of courses named courseCatalog, with the methods to add, remove Courses.
 * ALso a method to return the collection of courses
 */
public class CourseCatalogue {
    HashMap<String, Course> courseCatalogue = new HashMap<>();

    /**
     * Adds a course into the courseCatalogue
     *
     * @param id : String for the course's ID. For example: CMPU-20352
     * @param time: String for the time the course takes place. For example: "Monday 1:30-5:30"
     * @return boolean: true if the course was successfully put into the courseCatalogue
     */
    public boolean addCourse(String id, String time) {

        //todo we should probably make it so that as you add classes you can add prerequisites which would change the
        //todo addCourse above.
        LinkedList prequisites = new LinkedList();
        Course course = new Course(id, time, prequisites);
        courseCatalogue.put(id, course);

        return courseCatalogue.containsKey(id);
    }

    /**
     * Removes a course from the courseCatalogue
     *
     * @param id : String for the course's ID. For example: CMPU-20352
     * @return boolean: true if the course was successfully removed from course catalogue.
     * False if the course ID or course was not in the catalogue to begin with.
     */
    public boolean removeCourse(String id) {
        if (!courseCatalogue.containsKey(id))
            return false;
        courseCatalogue.remove(id);
        return !(courseCatalogue.containsKey(id));
    }
    public Course getCourse(String id){
        if (!courseCatalogue.containsKey(id))
            return null;
        courseCatalogue.remove(id);
        return courseCatalogue.get(id);
    }
    /**
     * @return The collection of courses in the courseCatalogue
     */
    public Set<String> returnCourseList() {
        return courseCatalogue.keySet();
    }


}

