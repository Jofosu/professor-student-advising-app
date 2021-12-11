package edu.vassar.cmpu203.team2a.controller;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;

import edu.vassar.cmpu203.team2a.view.DeptHeadMenuFragment;
import edu.vassar.cmpu203.team2a.view.advisorView.AddAdviseeViewFragment;
import edu.vassar.cmpu203.team2a.view.advisorView.AdvisorMenuFrag;
import edu.vassar.cmpu203.team2a.view.advisorView.DeleteAdviseeViewFragment;
import edu.vassar.cmpu203.team2a.view.MainMenuFragment;
import edu.vassar.cmpu203.team2a.view.authorizeView.AuthFragment;
import edu.vassar.cmpu203.team2a.view.deptHeadView.AddDepartmentCourseFragment;
import edu.vassar.cmpu203.team2a.view.deptHeadView.AddPoolCourseFragment;
import edu.vassar.cmpu203.team2a.view.deptHeadView.AddPoolNameFragment;
import edu.vassar.cmpu203.team2a.view.deptHeadView.EditPreqFragment;
import edu.vassar.cmpu203.team2a.view.deptHeadView.ManageCatalogueFragment;
import edu.vassar.cmpu203.team2a.view.deptHeadView.ManagePoolsFragment;
import edu.vassar.cmpu203.team2a.view.deptHeadView.PoolOptionsFragment;
import edu.vassar.cmpu203.team2a.view.deptHeadView.RemoveDepartmentCourseFragment;
import edu.vassar.cmpu203.team2a.view.deptHeadView.RemovePoolCourseFragment;
import edu.vassar.cmpu203.team2a.view.deptHeadView.RemovePoolNameFragment;
import edu.vassar.cmpu203.team2a.view.deptHeadView.ViewPoolCourses;


public class AdvisingAppFragFactory extends FragmentFactory {
    private final ControllerActivity controller;

    public AdvisingAppFragFactory(ControllerActivity controller) {
        this.controller = controller;
    }


    @NonNull
    @Override
    public Fragment instantiate(@NonNull ClassLoader classLoader, @NonNull String className) {

        Class<? extends Fragment> fragmentClass = loadFragmentClass(classLoader, className);

        Fragment fragment;
        //main menu and authentication
        if (fragmentClass == MainMenuFragment.class)
            fragment = new MainMenuFragment(controller);
        else if (fragmentClass == AuthFragment.class)
            fragment = new AuthFragment(controller);
        //Advisor screens
        else if (fragmentClass == AdvisorMenuFrag.class)
            fragment = new AdvisorMenuFrag(controller);
        else if (fragmentClass == AddAdviseeViewFragment.class)
            fragment = new AddAdviseeViewFragment(controller);
        else if (fragmentClass == DeleteAdviseeViewFragment.class)
            fragment = new DeleteAdviseeViewFragment(controller);
        //Dept chair screens
        else if (fragmentClass == DeptHeadMenuFragment.class)
            fragment = new DeptHeadMenuFragment(controller);
        else if (fragmentClass == ManageCatalogueFragment.class)
            fragment = new ManageCatalogueFragment(controller);
        else if (fragmentClass == AddDepartmentCourseFragment.class)
            fragment = new AddDepartmentCourseFragment(controller);
        else if (fragmentClass == RemoveDepartmentCourseFragment.class)
            fragment = new RemoveDepartmentCourseFragment(controller);
        else if (fragmentClass == EditPreqFragment.class)
            fragment = new EditPreqFragment(controller);
        //Pool fragments aka Major editing
        else if (fragmentClass == AddPoolCourseFragment.class)
            fragment = new AddPoolCourseFragment(controller);
        else if (fragmentClass == AddPoolNameFragment.class)
            fragment = new AddPoolNameFragment(controller);
        else if (fragmentClass == ManagePoolsFragment.class)
            fragment = new ManagePoolsFragment(controller);
        else if (fragmentClass == PoolOptionsFragment.class)
            fragment = new PoolOptionsFragment(controller);
        else if (fragmentClass == RemovePoolCourseFragment.class)
            fragment = new RemovePoolCourseFragment(controller);
        else if (fragmentClass == RemovePoolNameFragment.class)
            fragment = new RemovePoolNameFragment(controller);
       /*
       the constructor for this fragment currently takes a string as well as a listener
        else if (fragmentClass == ViewPoolCourses.class)
            fragment = new ViewPoolCourses(controller);
        */

        else fragment = super.instantiate(classLoader, className);

        return fragment;
    }
}
