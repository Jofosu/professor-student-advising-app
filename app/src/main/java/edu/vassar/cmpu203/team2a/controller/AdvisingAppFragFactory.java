package edu.vassar.cmpu203.team2a.controller;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import edu.vassar.cmpu203.team2a.view.AddAdviseeViewFragment;
import edu.vassar.cmpu203.team2a.view.DeleteAdviseeViewFragment;
import edu.vassar.cmpu203.team2a.view.MainMenuFragment;
import edu.vassar.cmpu203.team2a.view.ManageCatalogueFragment;


public class AdvisingAppFragFactory extends FragmentFactory {
    private ControllerActivity controller;

    public AdvisingAppFragFactory(ControllerActivity controller) {
        this.controller = controller;
    }


    @NonNull
    @Override
    public Fragment instantiate(@NonNull ClassLoader classLoader, @NonNull String className) {

        Class<? extends Fragment> fragmentClass = loadFragmentClass(classLoader, className);

        Fragment fragment;
        if (fragmentClass == AddAdviseeViewFragment.class)
            fragment = new AddAdviseeViewFragment(controller);
        else if (fragmentClass == DeleteAdviseeViewFragment.class)
            fragment = new DeleteAdviseeViewFragment(controller);
        else if (fragmentClass == MainMenuFragment.class)
                fragment = new MainMenuFragment(controller);
        else if (fragmentClass == ManageCatalogueFragment.class)
            fragment = new ManageCatalogueFragment(controller);
        else fragment = super.instantiate(classLoader, className);

        return fragment;
    }
}
