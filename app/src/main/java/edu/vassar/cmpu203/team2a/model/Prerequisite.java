package edu.vassar.cmpu203.team2a.model;

import java.util.LinkedList;

import edu.vassar.cmpu203.team2a.model.Course;

public class Prerequisite {

    public void addPrerequisites (Course course, LinkedList prequisites){
        course.prequisites = prequisites;
}
    public LinkedList returnPrequisites(Course course){
        return course.prequisites;
    }
}
