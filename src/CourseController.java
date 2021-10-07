import java.util.HashMap;

public class CourseController {
    HashMap<String,Course> courseCatalogue = new HashMap<>();

    public void addCourse(String id, String time){
        Course course = new Course(id,time);
        courseCatalogue.put(id,course);
    }

    public void removeCourse(String id){
        courseCatalogue.remove(id);
    }

    public void printCourseList(){

    }


}

