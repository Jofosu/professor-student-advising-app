package edu.vassar.cmpu203.team2a.view.deptHeadView;

public interface IEditPoolCourse {

    interface Listener{

        void removePoolCourseController(String idString, String poolName);

        void addPoolCourseController(String idString, String poolName);

    }
}
