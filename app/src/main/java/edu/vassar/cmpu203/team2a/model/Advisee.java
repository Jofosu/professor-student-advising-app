package edu.vassar.cmpu203.team2a.model;

import java.io.Serializable;
import java.util.List;

/**
 * Contains a constructor with the adviseeattributes name, Vassar "999 ID", and graduating class year
 */
public class Advisee {


    String name;

    public int getId() {
        return id;
    }

    public int getClassYear() {
        return classYear;
    }

    public List getClassesTaken() {
        return classesTaken;
    }

    int id;
    int classYear;
    List classesTaken;

    Advisee(String name, int id, int classYear, List classesTaken){
        this.name = name;
        this.id = id;
        this.classYear = classYear;
        this.classesTaken = classesTaken;
    }

    public String getName() {
        return name;
    }
}
