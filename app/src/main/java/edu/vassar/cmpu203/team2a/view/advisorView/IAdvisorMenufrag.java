package edu.vassar.cmpu203.team2a.view.advisorView;

import edu.vassar.cmpu203.team2a.model.Advisor;

public interface IAdvisorMenufrag {
    interface Listener{
        void updateMenuDisplay(Advisor advisor);
        void onSelectingAddAdvisee();
        void onSelectingDeleteAdvisee();
    }

}
