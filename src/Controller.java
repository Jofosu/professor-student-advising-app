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

    public boolean addAdvisee(String name, int id, int classYear) {
        if (advisor.addAdvisee(name, id, classYear))
            return true;
        return false;
    }

    public boolean deleteAdvisee(String name) {
        if (advisor.deleteAdvisee(name))
            return true;
        return false;
    }

    public Set<String> returnAdviseeList() {return advisor.returnAdviseeList();
    }
}
