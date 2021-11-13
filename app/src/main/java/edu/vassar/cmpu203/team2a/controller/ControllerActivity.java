package edu.vassar.cmpu203.team2a.controller;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import edu.vassar.cmpu203.team2a.view.IMainView;
import edu.vassar.cmpu203.team2a.view.MainView;
import edu.vassar.cmpu203.team2a.view.IOptionsMenu;
import edu.vassar.cmpu203.team2a.view.OptionsMenu;
import edu.vassar.cmpu203.team2a.model.*;


public class ControllerActivity extends AppCompatActivity implements IOptionsMenu {

    private IMainView mainView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        this.mainView = new MainView(this);

        this.setContentView(this.mainView.getRootView());
        this.mainView.displayFragment(new OptionsMenu(this));
    }
     //this method generates a different screen on a button push
     //public void onManageAdvisees(){this.mainView.displayFragment(<fragmentConstructor>)}












}
