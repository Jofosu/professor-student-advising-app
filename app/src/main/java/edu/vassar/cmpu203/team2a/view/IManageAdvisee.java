package edu.vassar.cmpu203.team2a.view;

public interface IManageAdvisee {

    public interface Listener{
        void addAdvisee(String name, int id, int classYear);
        void deleteAdvisee(String name, int id, int classYear);
    }

}
