import java.util.HashMap;

import java.util.Set;

/**
 *
 */
public class CourseCatalogue {
    HashMap<String, Course> courseCatalogue = new HashMap<>();

    public boolean addCourse(String id, String time) {
        Course course = new Course(id, time);
        courseCatalogue.put(id, course);

        return courseCatalogue.containsKey(id);
    }

    public boolean removeCourse(String id) {
        if (!courseCatalogue.containsKey(id))
            return false;
        courseCatalogue.remove(id);
        return !(courseCatalogue.containsKey(id));
    }

    public Set<String> returnCourseList() {
        return courseCatalogue.keySet();
    }


}

