package edu.vassar.cmpu203.team2a.view.advisorView;


public interface IAdvisorMenuView {
    interface Listener {

        void onSelectingAddAdvisee();

        void onSelectingDeleteAdvisee();
    }

    void updateMenuDisplay();
}
