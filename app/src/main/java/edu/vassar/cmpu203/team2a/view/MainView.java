package edu.vassar.cmpu203.team2a.view;

import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import edu.vassar.cmpu203.team2a.databinding.MainViewBinding;


public class MainView implements IMainView{

    private final FragmentActivity activity;
    private final MainViewBinding binding;

    public MainView(FragmentActivity activity){
        this.binding = MainViewBinding.inflate(activity.getLayoutInflater());
        this.activity = activity;
    }


    @Override
    public View getRootView() {
        return this.binding.getRoot();
    }
    @Override
    public void displayFragment(Fragment fragment) {

        this.activity.getSupportFragmentManager()
                .beginTransaction()
                .replace(this.binding.fragmentContainerView.getId(), fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public Fragment getCurrentFragment() {
        return this.binding.fragmentContainerView.getFragment();
    }
}
