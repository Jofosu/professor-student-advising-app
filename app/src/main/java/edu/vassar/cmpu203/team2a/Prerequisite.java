package edu.vassar.cmpu203.team2a;

import java.util.LinkedList;

public class Prerequisite {

    public void addPrerequisites (Course course, LinkedList prequisites){
        course.prequisites = prequisites;
}
    public LinkedList returnPrequisites(Course course){
        return course.prequisites;
    }
}
