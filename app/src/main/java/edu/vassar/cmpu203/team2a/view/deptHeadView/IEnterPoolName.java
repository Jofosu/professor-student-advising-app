package edu.vassar.cmpu203.team2a.view.deptHeadView;

public interface IEnterPoolName {
    interface Listener{

        void removePool(String idString);

        void onPoolAdded(String idString);

        void onRemovePool(String idString);
    }
}
