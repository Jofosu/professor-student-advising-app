import java.util.HashMap;
import java.util.Set;

public class AdviseeController {

    HashMap<String, Advisee> advisees = new HashMap<>(); //create collection of advisees

    public boolean addAdvisee(String name, int id, int classYear) {
        if (String.valueOf(id).length() == 9 & String.valueOf(classYear).length() == 4) {
            Advisee advisee = new Advisee(name, id, classYear);
            advisees.put(name, advisee);
            return advisees.containsKey(name);
        } else {
            return false;
        }
    }

    public boolean deleteAdvisee(String name) {
        if (!advisees.containsKey(name))
            return false;                        //check if advisee is on list if not, return false
        advisees.remove(name);
        return !(advisees.containsKey(name));    //return true if remove was successful
    }

    public Set<String> returnAdviseeList() {
        return advisees.keySet();
    }

}
