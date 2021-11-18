package edu.vassar.cmpu203.team2a.controller;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import edu.vassar.cmpu203.team2a.view.IMainView;
import edu.vassar.cmpu203.team2a.view.IManageAdviseesMenu;
import edu.vassar.cmpu203.team2a.view.MainView;
import edu.vassar.cmpu203.team2a.view.IOptionsMenu;
import edu.vassar.cmpu203.team2a.view.OptionsMenu;
import edu.vassar.cmpu203.team2a.model.*;


public class ControllerActivity extends AppCompatActivity implements IOptionsMenu.Listener, IManageAdviseesMenu.Listener {

    private IMainView mainView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        this.mainView = new MainView(this);

        this.setContentView(this.mainView.getRootView());
       //  this.mainView.displayFragment(new OptionsMenu(this));
    }

    //TODO switch functionality from Controller class to ControllerActivity class
    /**
     *
     //IOptionsMenu implementation
     @Override
     public void onManageCourses(){
        this.mainView.displayFragment();
     }
     @Override
     public void onMajorReq(){
     this.mainView.displayFragment();
     }
     @Override
     public void onManageAdvisees(){
        this.mainView.displayFragment(<ManageAdviseesMenu()>);
     }

    //IManageAdviseesMenu.Listener implementation
     @Override
     void onAddAdvisee();
     void onDeleteAdvisee();
     void onEditAdvisee();

*/











}
