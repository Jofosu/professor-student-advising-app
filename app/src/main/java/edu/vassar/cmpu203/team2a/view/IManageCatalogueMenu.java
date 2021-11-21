package edu.vassar.cmpu203.team2a.view;

import edu.vassar.cmpu203.team2a.model.CourseCatalogue;

public interface IManageCatalogueMenu {
    public interface Listener{
        void onSelectAdd();

    }
    public void updateDisplay(CourseCatalogue catalogue);
}
