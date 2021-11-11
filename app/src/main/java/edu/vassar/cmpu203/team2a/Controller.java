package edu.vassar.cmpu203.team2a;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import edu.vassar.cmpu203.team2a.model.Advisor;
import edu.vassar.cmpu203.team2a.model.Course;
import edu.vassar.cmpu203.team2a.model.CourseCatalogue;
import edu.vassar.cmpu203.team2a.model.Major;
import edu.vassar.cmpu203.team2a.model.Prerequisite;

/**
 * Controller class, every input runs through here
 */
public class Controller {
    CourseCatalogue courseCatalogue = new CourseCatalogue();
    Advisor advisor = new Advisor();
    Prerequisite prerequisite = new Prerequisite();
    List classesTaken = new LinkedList();
    Major major = new Major();

    /**
     * Adds courses to the course catalogue for use elsewhere in the system
     * @param id is the course ID, 4 character alphabet with 3 numbers
     * @param time Fall/ Spring/ or both offering
     * @return true/false if the class worked
     */
    public boolean addCourse(String id, String time) {
        return courseCatalogue.addCourse(id, time);
    }

    /**
     * Removes a class from the course catalogue using the course ID
     * @param id course ID, 4 character alphabet with 3 numbers
     * @return true/false if the class worked
     */
    public boolean removeCourse(String id) {
        return courseCatalogue.removeCourse(id);
    }

    /**
     * Sends the current course catalogue for viewing
     * @return A set with all of the courses
     */
    public Set<String> returnCourseList() {
        return courseCatalogue.returnCourseList();
    }

    /**
     * Adds an advisee to the advisors list
     * @param name students name
     * @param id students 999 number
     * @param classYear students graduating year
     * @param classesTaken list of the courses the student has already taken
     * @return true/false on if it worked or not
     */
    public boolean addAdvisee(String name, int id, int classYear, List classesTaken) {
        return advisor.addAdvisee(name, id, classYear, classesTaken);
    }

    /**
     * Removes a student from the advisors list
     * @param id the students 999 number
     * @return true/ false on if it worked or not
     */
    public boolean deleteAdvisee(int id) {
        return advisor.deleteAdvisee(id);
    }

    /**
     * Sends back a list of the current advisees for an advisor
     * @return set of all the advisees
     */
    public Set<String> returnAdviseeList() {
        return advisor.returnAdviseeList();
    }

    /**
     * Not yet fully implemented, adds a class to the advisees class taken list
     * @param classToAdd what course to add, it MUST be on the course catalogue
     * @return true/false on if it worked
     */
    public boolean addClass(String classToAdd) {
        if (courseCatalogue.inCatalogue(classToAdd))
            return classesTaken.add(courseCatalogue.get(classToAdd));
        return false;
    }

    /**
     * Adds prerequisites to a prerequisite list that all courses have
     * @param id course that is getting a prerequisite added to it
     * @param id2 course that is a prerequisite of it
     */
    public void addPrerequisites (String id, String id2){
        prerequisite.addPrerequisites(courseCatalogue.getCourse(id), courseCatalogue.getCourse(id2));
    }

    /**
     * Returns all prerequisites that a course has
     * @param id course that is being checked
     * @return list of courses of prerequisites
     */
    public LinkedList returnPrerequisites(String id) {
        return prerequisite.returnPrerequisites(courseCatalogue.getCourse(id));
    }

    /**
     * Adds courses to a Pool in a Major
     * @param courseToAdd A course that is added to a pool in a major
     * @param pool A list of courses that are either optional or required for a major
     * @return true/false if the the course was added to an existing pool
     */
    public boolean addCourse(Course courseToAdd, String pool) {
        return major.addCourse(courseToAdd, pool);
    }
    /**
     * Creates a Pool in a Major
     * @param poolName A course that is added to a pool in a major
     * @return true/false if the the Pool was added to a Major
     */
    public boolean createPool(String poolName) {
        return major.createPool(poolName);
    }

}
