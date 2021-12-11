package edu.vassar.cmpu203.team2a.model;

import com.google.rpc.Help;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * Contains a constructor for a Vassar course, which have the attributes course-ID (id) and time it takes place (time)
 */
public class Course implements Serializable {
     String id;
     String time;
     ArrayList<String> prerequisites;

    /**
     * Empty course constructor
     */
    public Course(){
        this.id = getId();
        this.time = getTime();
        this.prerequisites = getPrerequisites();
    }



    /**
     * Course constructor
     * @param id course id
     * @param time course time
     * @param prerequisites course prerequisites
     */
    public Course(String id, String time, ArrayList prerequisites){
        this.id = id;
        this.time = time;
        this.prerequisites = prerequisites;
    }

    /**
     * Getter for course id
     * @return course id
     */
    public String getId(){return id;}

    /**
     * Getter for time
     * @return returns course time
     */
    public String getTime(){return time;}

    /**
     * getter for pre requisites
     * @return
     */
    public ArrayList<String> getPrerequisites(){ return prerequisites;}


    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Course))
            return false;
        return this.id == ((Course) obj).id;
    }

    /**
     * To string method
     * @return returns course id
     */
    public String toString(){return this.id;}
}