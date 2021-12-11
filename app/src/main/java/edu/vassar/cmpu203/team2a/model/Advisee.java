package edu.vassar.cmpu203.team2a.model;

import java.io.Serializable;
import java.util.List;

/**
 * Contains a constructor with the adviseeattributes name, Vassar "999 ID", and graduating class year
 */
public class Advisee implements Serializable{
    String name;
    int id;
    int classYear;
    List<Course> classesTaken;

    /**
     * Empty constructor for Advisee class, returns internal components
     */
    Advisee(){
        this.name =  getName();
        this.id = getId();
        this.classYear=getClassYear();
        this.classesTaken  = getClassesTaken();
    }

    /**
     * Constructor for Advisee class
     * @param name name of student
     * @param id students 999 number
     * @param classYear graduation year
     * @param classesTaken what classes have been taken
     */
    Advisee(String name, int id, int classYear, List<Course> classesTaken){
        this.name = name;
        this.id = id;
        this.classYear = classYear;
        this.classesTaken = classesTaken;
    }

    /**
     * Getter for student's name
     * @return student's name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for student's id
     * @return student's id
     */
    public int getId() {
        return id;
    }

    /**
     * Getter for student's class year
     * @return student's id
     */
    public int getClassYear() {
        return classYear;
    }

    /**
     * Getter for classes taken
     * @return list of classes taken
     */
    public List<Course> getClassesTaken() {
        return classesTaken;
    }
}
