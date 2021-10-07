import java.util.HashMap;

public class AdviseeController {

    HashMap<String, Advisee> advisees = new HashMap<>(); //create collection of advisees

    public boolean addAdvisee(String name, String id, int classYear){
        Advisee advisee = new Advisee(name, id, classYear);
        advisees.put(name, advisee);
        return advisees.containsKey(name);
    }

    public boolean deleteAdvisee(String name){
        if (!advisees.containsKey(name))
            return false;                        //check if advisee is on list
        advisees.remove(name);
        return !(advisees.containsKey(name));    //return true if remove was successful
    }



}
