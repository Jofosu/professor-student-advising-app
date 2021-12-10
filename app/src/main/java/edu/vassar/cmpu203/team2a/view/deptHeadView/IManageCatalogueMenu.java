package edu.vassar.cmpu203.team2a.view.deptHeadView;

import edu.vassar.cmpu203.team2a.model.CourseCatalogue;

public interface IManageCatalogueMenu {
    interface Listener{
        void onAddCourse();
        void onRemoveCourse();
        void onEditPreq();


    }
    void updateMenuDisplay(CourseCatalogue courseCatalogue);
}
