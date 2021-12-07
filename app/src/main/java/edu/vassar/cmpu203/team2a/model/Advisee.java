package edu.vassar.cmpu203.team2a.model;

import java.io.Serializable;
import java.util.List;

/**
 * Contains a constructor with the adviseeattributes name, Vassar "999 ID", and graduating class year
 */
public class Advisee implements Serializable{


    String name;

    public int getId() {
        return id;
    }

    public int getClassYear() {
        return classYear;
    }

    public List<Course> getClassesTaken() {
        return classesTaken;
    }


    int id;
    int classYear;
    List<Course> classesTaken;
    Advisee(){
        this.name =  getName();
        this.id = getId();
        this.classYear=getClassYear();
        this.classesTaken  = getClassesTaken();
    }
    Advisee(String name, int id, int classYear, List<Course> classesTaken){
        this.name = name;
        this.id = id;
        this.classYear = classYear;
        this.classesTaken = classesTaken;
    }


    public String getName() {
        return name;
    }
}
