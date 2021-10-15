import java.util.List;
import java.util.Set;

public class Controller {
    CourseCatalogue courseCatalogue = new CourseCatalogue();
    Advisor advisor = new Advisor();
    
    public boolean addCourse(String id, String time) {
        return courseCatalogue.addCourse(id, time);
    }

    public boolean removeCourse(String id) {
        return courseCatalogue.removeCourse(id);
    }

    public Set<String> returnCourseList() {
       return courseCatalogue.returnCourseList();
    }

    public boolean addAdvisee(String name, int id, int classYear, List classesTaken) {
        return advisor.addAdvisee(name, id, classYear, classesTaken);
    }

    public boolean deleteAdvisee(int id) {
        return advisor.deleteAdvisee(id);
    }

    public Set<String> returnAdviseeList() {return advisor.returnAdviseeList();
    }
}
