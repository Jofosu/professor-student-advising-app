import java.util.ArrayList;

public class CourseController {
    ArrayList<Course> courseCatalogue = new ArrayList<>();

    public void addCourse(String id, String time){
        Course course = new Course(id,time);
        courseCatalogue.add(course);
    }

}

