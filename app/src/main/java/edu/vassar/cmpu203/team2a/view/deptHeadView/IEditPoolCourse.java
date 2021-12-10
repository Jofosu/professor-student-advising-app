package edu.vassar.cmpu203.team2a.view.deptHeadView;

public interface IEditPoolCourse {

    interface Listener{

        void removePoolCourse(String idString, String poolName);

        void addPoolCourse(String idString, String poolName);

    }
}
