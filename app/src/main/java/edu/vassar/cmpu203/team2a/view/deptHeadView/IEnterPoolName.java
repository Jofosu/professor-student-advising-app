package edu.vassar.cmpu203.team2a.view.deptHeadView;
import edu.vassar.cmpu203.team2a.model.Major;

public interface IEnterPoolName {
    interface Listener{

        void removePool(String idString);

        void createPool(String idString);
    }
}
