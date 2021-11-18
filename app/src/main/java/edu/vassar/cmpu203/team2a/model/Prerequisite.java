package edu.vassar.cmpu203.team2a.model;

import java.util.LinkedList;

/**
 * Handles Prerequisites
 */
public class Prerequisite {

    /**
     * Adds prerequisites to courses
     * @param course course that the prerequisites are added to
     * @param course2 course prerequisites
     */
    public void addPrerequisites (Course course, Course course2){
        course.prerequisites.add(course2);
}

    /**
     * Returns the list of prerequisites
     * @param course course that we are checking prerequisites for
     * @return list of prerequisites
     */
    public LinkedList returnPrerequisites(Course course){
        return course.prerequisites;
    }
}
