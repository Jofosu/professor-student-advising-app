package edu.vassar.cmpu203.team2a.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Contains a Hashmap list of advisees belonging to an adviser. There is a method to add an advisee to the list,
 * a method to remove an advisee, and a method to return a list of advisees
 */
public class Advisor implements Serializable {

    HashMap<Integer, Advisee> advisees = new HashMap<>(); //create Hashmap collection of advisees

    /**
     * adds an advisee to the Hashmap collection of advisees
     *
     * @param name
     * @param id:        Normally a Vassar ID consist of a 9-digit number
     * @param classYear: 4-digit number for the advisee's graduation year
     * @return true if an advisee was successfully added to the list,
     * false if the ID was not 9-digit or class year was not 4-digit. This is to avoid some typos.
     */

    public boolean addAdvisee(String name, int id, int classYear, List classesTaken, String advisor, String major) {
        if (String.valueOf(id).length() == 9 & String.valueOf(classYear).length() == 4) {
            Advisee advisee = new Advisee(name, id, classYear, classesTaken, advisor, major);
            advisees.put(id, advisee);
            return advisees.containsKey(id);
        } else {
            return false;
        }
    }

    /**
     * Gets list of advisee's names
     *
     * @return list of advisee's names
     */
    public List<String> adviseeNames() {
        List<String> listy = new ArrayList<>();
        for (Advisee advisee : this.returnAdviseeList()) {
            listy.add(advisee.getName());
        }
        return listy;
    }


    /**
     * Remove an advisee from the list of advisees
     *
     * @param id
     * @return true if advisee was successfully removed, false if the advisee's name was not in the collection
     */
    public boolean deleteAdvisee(int id) {
        if (!advisees.containsKey(id))
            return false;
        advisees.remove(id);
        return !(advisees.containsKey(id));
    }

    public Set<Integer> returnAdviseeIds() {
        return advisees.keySet();
    }


    /**
     * @return the list/collection of advisees
     */
    public Set<Advisee> returnAdviseeList() {
        Set<Advisee> names = new HashSet<>();
        for (Advisee advisee : advisees.values()) {
            names.add(advisee);
        }
        return names;
    }

    /**
     * @return the number of advisees for a given advisor
     */
    public int size() {
        return advisees.size();
    }

    /**
     * Easy way of getting an advisee object
     *
     * @param id 999 number
     * @return advisee object
     */
    public Advisee getAdvisee(int id) {
        return advisees.get(id);
    }

    /**
     * Adds a class taken to an advisee
     *
     * @param advisee advisee object
     * @param c       course object
     * @return boolean if it added or not
     */
    public boolean addClassTaken(Advisee advisee, Course c) {
        return advisee.getClassesTaken().add(c);
    }

    /**
     * @param adviseeName advisee name
     * @return returns the associated id of the advisee name
     */
    public int getAdviseeID(String adviseeName) {
        for (Advisee advisee : advisees.values()) {
            if (advisee.getName() == adviseeName)
                return advisee.getId();
        }
        return -1;
    }
}
