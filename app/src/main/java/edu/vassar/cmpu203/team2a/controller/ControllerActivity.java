package edu.vassar.cmpu203.team2a.controller;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;

import edu.vassar.cmpu203.team2a.model.Course;
import edu.vassar.cmpu203.team2a.model.CourseCatalogue;
import edu.vassar.cmpu203.team2a.view.AddAdviseeViewFragment;
import edu.vassar.cmpu203.team2a.view.DeleteAdviseeViewFragment;
import edu.vassar.cmpu203.team2a.view.IAddDeptCourseView;
import edu.vassar.cmpu203.team2a.view.IMainMenuFragment;
import edu.vassar.cmpu203.team2a.view.IMainView;
import edu.vassar.cmpu203.team2a.view.IManageAdviseeView;
import edu.vassar.cmpu203.team2a.view.IManageAdviseesFragment;
import edu.vassar.cmpu203.team2a.view.IOptionsMenu;
import edu.vassar.cmpu203.team2a.view.MainMenuFragment;
import edu.vassar.cmpu203.team2a.view.MainView;
import edu.vassar.cmpu203.team2a.view.ManageAdviseesFragment;
import edu.vassar.cmpu203.team2a.view.OptionsMenuFragment;

public class ControllerActivity extends AppCompatActivity implements IAddDeptCourseView.Listener, IManageAdviseeView.Listener, IMainMenuFragment.Listener, IOptionsMenu.Listener, IManageAdviseesFragment.Listener {
    private Course course;
    private IMainView mainView;
    private CourseCatalogue courseCatalogue;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FragmentFactory fragmentFactory = new AdvisingAppFragFactory(this);
        this.getSupportFragmentManager().setFragmentFactory(fragmentFactory);
        super.onCreate(savedInstanceState);
        Log.i("MainMenu","onCreate activity");
       this.mainView = new MainView(this);
       this.setContentView(this.mainView.getRootView());
       this.mainView.displayFragment(new MainMenuFragment(this));
    }

    @Override
    public void onAddedCourse(String id, String time, IAddDeptCourseView AddDeptCourseView) {
        Log.d("AdvisingApp", "controller is handling adding a course");
        this.courseCatalogue.addCourse(id, time);
        AddDeptCourseView.updateDisplay(this.course);
    }

    @Override
    public void onCourseDone() {

    }


    @Override
    public void addAdvisee(String name, int id, int classYear) {

    }

    @Override
    public void deleteAdvisee(String name, int id, int classYear) {

    }

    @Override
    public void onSelectingStudent() {

    }

    @Override
    public void onSelectingAdvisor() {
        Fragment f = new ManageAdviseesFragment(this);
        this.mainView.displayFragment(f);
    }

    @Override
    public void onSelectingHOD() {
        Fragment f = new OptionsMenuFragment(this);
        this.mainView.displayFragment(f);
    }

    @Override
    public void onManageCourses() {

    }

    @Override
    public void onMajorReq() {

    }

    @Override
    public void onManageAdvisees() {

    }

    
    public void AddAdvisee(String name, int id, int classYear) {

    }

   // @Override
    //public void onDeleteAdvisee(int id) {

   // }

    @Override
    public void onSelectingAddAdvisee() {
        Fragment f = new AddAdviseeViewFragment(this);
        this.mainView.displayFragment(f);
    }

    @Override
    public void onSelectingDeleteAdvisee() {
        Fragment f = new DeleteAdviseeViewFragment(this);
        this.mainView.displayFragment(f);
    }
}