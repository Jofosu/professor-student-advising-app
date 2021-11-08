package edu.vassar.cmpu203.team2a.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.vassar.cmpu203.team2a.model.Advisee;

/**
 *  Contains a Hashmap list of advisees belonging to an adviser. There is a method to add an advisee to the list,
 *  a method to remove an advisee, and a method to return a list of advisees
 */
public class Advisor {

    HashMap<Integer, Advisee> advisees = new HashMap<>(); //create Hashmap collection of advisees

    /**
     * adds an advisee to the Hashmap collection of advisees
     *
     * @param name
     * @param id: Normally a Vassar ID consist of a 9-digit number
     * @param classYear: 4-digit number for the advisee's graduation year
     * @return true if an advisee was successfully added to the list,
     * false if the ID was not 9-digit or class year was not 4-digit. This is to avoid some typos.
     */
    public boolean addAdvisee(String name, int id, int classYear, List classesTaken) {
        if (String.valueOf(id).length() == 9 & String.valueOf(classYear).length() == 4) {
            Advisee advisee = new Advisee(name, id, classYear, classesTaken);
            advisees.put(id, advisee);
            return advisees.containsKey(id);
        } else {
            return false;
        }
    }

    /**
     * Remove an advisee from the list of advisees
     * @param id
     * @return true if advisee was successfully removed, false if the advisee's name was not in the collection
     */
    public boolean deleteAdvisee(int id) {
        if (!advisees.containsKey(id))
            return false;
        advisees.remove(id);
        return !(advisees.containsKey(id));
    }

    /**
     * @return the list/collection of advisees
     */
    public Set<String> returnAdviseeList() {
        Set<String> names = new HashSet<>();
        for(Advisee advisee : advisees.values()){
            names.add(advisee.name + "-" + advisee.id);
        }
        return names;
    }

    /**
     * @return the number of advisees for a given advisor
     */
    public int size(){
        return advisees.size();
    }


}
