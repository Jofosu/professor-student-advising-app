package edu.vassar.cmpu203.team2a.view.advisorView;

public interface IManageAdviseeView {
    interface Listener{
        void addAdvisee(String name, int id, int classYear, String major);

        void deleteAdvisee(int id);

    }

}
