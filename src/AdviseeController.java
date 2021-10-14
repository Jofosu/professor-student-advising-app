import java.util.HashMap;
import java.util.Set;

/**
 *  Contains a Hashmap list of advisees belonging to an adviser. There is a method to add an advisee to the list,
 *  a method to remove an advisee, and a method to return a list of advisees
 */
public class AdviseeController {

    HashMap<String, Advisee> advisees = new HashMap<>(); //create Hashmap collection of advisees

    /**
     * adds an advisee to the Hashmap collection of advisees
     *
     * @param name
     * @param id: Normally a Vassar ID consist of a 9-digit number
     * @param classYear: 4-digit number for the advisee's graduation year
     * @return true if an advisee was successfully added to the list,
     * false if the ID was not 9-digit or class year was not 4-digit. This is to avoid some typos.
     */
    public boolean addAdvisee(String name, int id, int classYear) {
        if (String.valueOf(id).length() == 9 & String.valueOf(classYear).length() == 4) {
            Advisee advisee = new Advisee(name, id, classYear);
            advisees.put(name, advisee);
            return advisees.containsKey(name);
        } else {
            return false;
        }
    }

    /**
     * Remove an advisee from the list of advisees
     * @param name
     * @return true if advisee was successfully removed, false if the advisee's name was not in the collection
     */
    public boolean deleteAdvisee(String name) {
        if (!advisees.containsKey(name))
            return false;
        advisees.remove(name);
        return !(advisees.containsKey(name));
    }

    /**
     * @return the list/collection of adivsees
     */
    public Set<String> returnAdviseeList() {return advisees.keySet();
    }

}
