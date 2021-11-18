package edu.vassar.cmpu203.team2a.view;
import edu.vassar.cmpu203.team2a.model.Course;
import edu.vassar.cmpu203.team2a.model.CourseCatalogue;


public interface IAddDeptCourseView {
    public interface Listener{
        void onAddedCourse(String id, String time,IAddDeptCourseView AddDeptCourseView);
        void onCourseDone();
    }
    public void updateDisplay(Course course);
}
