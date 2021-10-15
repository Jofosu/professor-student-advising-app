import java.util.List;
import java.util.Map;
import java.util.Set;

public class Controller {
    CourseCatalogue courseCatalogue = new CourseCatalogue();
    Advisor advisor = new Advisor();
    
    public boolean addCourse(String id, String time) {
        if(courseCatalogue.addCourse(id, time))
            return true;
        return false;
    }

    public boolean removeCourse(String id) {
        if(courseCatalogue.removeCourse(id))
            return true;
        return false;
    }

    public Set<String> returnCourseList() {
       return courseCatalogue.returnCourseList();
    }

    public boolean addAdvisee(String name, int id, int classYear, List classesTaken) {
        if (advisor.addAdvisee(name, id, classYear,classesTaken))
            return true;
        return false;
    }

    public boolean deleteAdvisee(int id) {
        if (advisor.deleteAdvisee(id))
            return true;
        return false;
    }

    public Set<String> returnAdviseeList() {return advisor.returnAdviseeList();
    }
}
