package edu.vassar.cmpu203.team2a.view.deptHeadView;
import edu.vassar.cmpu203.team2a.model.Course;


public interface IAddDeptCourseView {
    interface Listener{
        void onAddedCourse(String id, String time);
        void onCourseDone();
    }

}
