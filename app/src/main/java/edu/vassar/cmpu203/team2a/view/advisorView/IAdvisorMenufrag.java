package edu.vassar.cmpu203.team2a.view.advisorView;

import edu.vassar.cmpu203.team2a.model.Advisor;

public interface IAdvisorMenufrag {
    interface Listener{

        void onSelectingAddAdvisee();
        void onSelectingDeleteAdvisee();
    }
    void updateMenuDisplay();
}
