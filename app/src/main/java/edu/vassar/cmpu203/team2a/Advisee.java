package edu.vassar.cmpu203.team2a;

import java.util.LinkedList;
import java.util.List;

/**
 * Contains a constructor with the adviseeattributes name, Vassar "999 ID", and graduating class year
 */
public class Advisee {
    String name;
    int id;
    int classYear;
    List classesTaken = new LinkedList();

    Advisee(String name, int id, int classYear, List classesTaken){
        this.name = name;
        this.id = id;
        this.classYear = classYear;
        this.classesTaken = classesTaken;
    }

    public boolean addClass(Course c){
        return classesTaken.add(c);
    }

}
