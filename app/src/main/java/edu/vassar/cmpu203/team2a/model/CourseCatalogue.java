package edu.vassar.cmpu203.team2a.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Contains a HashMap collection of courses named courseCatalog, with the methods to add, remove Courses.
 * ALso a method to return the collection of courses
 */
public class CourseCatalogue implements Serializable {
    private final HashMap<String, Course> courseCatalogue = new HashMap<>();

    /**
     * Empty constructor
     */
    public CourseCatalogue() {
    }

    /**
     * Adds a course into the courseCatalogue
     *
     * @param id    : String for the course's ID. For example: CMPU-20352
     * @param time: String for the time the course takes place. For example: "Monday 1:30-5:30"
     * @return boolean: true if the course was successfully put into the courseCatalogue
     */
    public boolean addCourse(String id, String time, ArrayList prerequisites) {
        Course course = new Course(id, time, prerequisites);
        courseCatalogue.put(id, course);

        return courseCatalogue.containsKey(id);
    }


    /**
     * gets course catalogue
     *
     * @return course catalogue hashmap
     */
    public HashMap<String, Course> getCourseCatalogue() {
        return courseCatalogue;
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


    /**
     * @return The collection of courses in the courseCatalogue
     */
    public Set<String> returnCourseList() {
        return courseCatalogue.keySet();
    }

    /**
     * @return number of items in course catalogue
     */
    public int size() {
        return courseCatalogue.size();
    }

    /**
     * check if a course is in the course catalogue
     */
    public boolean inCatalogue(String courseID) {
        return courseCatalogue.containsKey(courseID);
    }

    /**
     * return a course object from the catalogue using the courseID
     */
    public Course get(String courseID) {
        return courseCatalogue.get(courseID);
    }

    /**
     * Edits time
     *
     * @param id   course id
     * @param time course time
     */
    public void editTime(String id, String time) {
        courseCatalogue.get(id).time = time;
    }
}

