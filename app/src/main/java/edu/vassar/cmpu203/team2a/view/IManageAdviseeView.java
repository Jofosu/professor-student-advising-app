package edu.vassar.cmpu203.team2a.view;

public interface IManageAdviseeView {
    interface Listener{
        void addAdvisee(String name,int id, int classYear);
        void deleteAdvisee(int id);
    }
}
