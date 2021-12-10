package edu.vassar.cmpu203.team2a.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;


/**
 * Contains a constructor for a Vassar course, which have the attributes course-ID (id) and time it takes place (time)
 */
public class Course implements Serializable {
     String id;
     String time;
     public ArrayList<String> prerequisites;

    public Course(){
        this.id = getId();
        this.time = getTime();
        this.prerequisites = getPrerequisites();
    }

    public ArrayList<String> returnPrerequisites(Course course){
        return course.prerequisites;
    }

    public String getId(){return id;}
    public String getTime(){return time;}

    public Course(String id, String time, ArrayList prerequisites){
        this.id = id;
        this.time = time;
        this.prerequisites = prerequisites;
    }

    public ArrayList<String> getPrerequisites(){
        return prerequisites;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Course))
            return false;
        return this.id == ((Course) obj).id;
    }
}