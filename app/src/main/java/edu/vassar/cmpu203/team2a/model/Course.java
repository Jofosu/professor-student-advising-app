package edu.vassar.cmpu203.team2a.model;

import java.util.LinkedList;


/**
 * Contains a constructor for a Vassar course, which have the attributes course-ID (id) and time it takes place (time)
 */
public class Course {
    String id;
    String time;
    LinkedList prerequisites;


    public Course(String id, String time, LinkedList prerequisites){
        this.id = id;
        this.time = time;
        this.prerequisites = prerequisites;
    }
}