import java.util.ArrayList;

public class AdviseeController {

    ArrayList<Advisee> advisees = new ArrayList<>();

    public void addAdvisee(String name, int id, int classYear){
        Advisee advisee = new Advisee(name, id, classYear);
        advisees.add(advisee);
    }

}
