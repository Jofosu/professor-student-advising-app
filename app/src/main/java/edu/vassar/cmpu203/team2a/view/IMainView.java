package edu.vassar.cmpu203.team2a.view;

import android.view.View;

import androidx.fragment.app.Fragment;

public interface IMainView {

    View getRootView();
    void displayFragment(Fragment fragment);

   Fragment getCurrentFragment();
}
