package edu.vassar.cmpu203.team2a.view.deptHeadView;
import edu.vassar.cmpu203.team2a.model.Course;
import edu.vassar.cmpu203.team2a.model.CourseCatalogue;


public interface IAddDeptCourseView {



    interface Listener{
        void onAddedCourse(String id, String time);
    }
}
