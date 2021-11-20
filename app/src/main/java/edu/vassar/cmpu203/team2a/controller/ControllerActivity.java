package edu.vassar.cmpu203.team2a.controller;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import edu.vassar.cmpu203.team2a.view.IMainView;
import edu.vassar.cmpu203.team2a.view.IManageAdvisee;
import edu.vassar.cmpu203.team2a.view.IManageAdviseesMenu;
import edu.vassar.cmpu203.team2a.view.MainView;
import edu.vassar.cmpu203.team2a.view.IOptionsMenu;
import edu.vassar.cmpu203.team2a.view.ManageAdviseesMenu;
import edu.vassar.cmpu203.team2a.view.AddAdvisee;
import edu.vassar.cmpu203.team2a.view.OptionsMenu;
import edu.vassar.cmpu203.team2a.model.*;


public class ControllerActivity extends AppCompatActivity implements IOptionsMenu.Listener, IManageAdviseesMenu.Listener {

    private IMainView mainView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        this.mainView = new MainView(this);

        this.setContentView(this.mainView.getRootView());
        this.mainView.displayFragment(new OptionsMenu(this));
    }

    //TODO switch functionality from Controller class to ControllerActivity class

    @Override
    public void onManageCourses() {

    }

    @Override
    public void onMajorReq() {

    }

    /**
     *
     //IOptionsMenu implementation -- opens new screens
     @Override
     public void onManageCourses(){
        this.mainView.displayFragment();
     }
     @Override
     public void onMajorReq(){
     this.mainView.displayFragment();
     }
     */

     @Override
     public void onManageAdvisees(){
        this.mainView.displayFragment(new ManageAdviseesMenu(this));
     }

    //IManageAdviseesMenu.Listener implementation -- opens new screens
     @Override
     public void onAddAdvisee(){
         this.mainView.displayFragment(new AddAdvisee((IManageAdvisee.Listener) this));
     }

    @Override
    public void onDeleteAdvisee() {

    }

    @Override
    public void onEditAdvisee() {

    }
    /**
     void onDeleteAdvisee{
     this.mainView.displayFragment(new deleteAdvisee(this));
     }
*/
    /**
     *  //AddAdvisee implementation-- calls the methods from the model
     *
     *  void addAdvisee(String name, int id, int classYear){
     *
     *  }
     *
     *  void deleteAdvisee(){
     *
     *  }
     *
     *
     *
     */












}
