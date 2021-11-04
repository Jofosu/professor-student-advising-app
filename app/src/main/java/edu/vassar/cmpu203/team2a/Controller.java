package edu.vassar.cmpu203.team2a;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Controller class, every input runs through here
 */
public class Controller {
    CourseCatalogue courseCatalogue = new CourseCatalogue();
    Advisor advisor = new Advisor();
    Prerequisite prerequisite = new Prerequisite();
    List classesTaken = new LinkedList();


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
        if (courseCatalogue.courseCatalogue.containsKey(classToAdd))
            return classesTaken.add(courseCatalogue.courseCatalogue.get(classToAdd));
        return false;
    }

    //todo depending on how we implement the gui, this accepting a linked list may need to change
    public void addPrerequisites (String id, LinkedList prequisites){
        prerequisite.addPrerequisites(courseCatalogue.getCourse(id), prequisites);
    }
    public LinkedList returnPrequisites(String id) {
        return prerequisite.returnPrequisites(courseCatalogue.getCourse(id));
    }

}
