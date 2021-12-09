package edu.vassar.cmpu203.team2a.controller;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;

import java.util.LinkedList;

import edu.vassar.cmpu203.team2a.model.Advisor;
import edu.vassar.cmpu203.team2a.model.CourseCatalogue;
import edu.vassar.cmpu203.team2a.model.Major;
import edu.vassar.cmpu203.team2a.persistence.FirestoreFacade;
import edu.vassar.cmpu203.team2a.persistence.IpersistenceFacade;
import edu.vassar.cmpu203.team2a.view.DeptHeadMenuFragment;
import edu.vassar.cmpu203.team2a.view.IDeptHeadMenu;
import edu.vassar.cmpu203.team2a.view.advisorView.AddAdviseeViewFragment;
import edu.vassar.cmpu203.team2a.view.advisorView.DeleteAdviseeViewFragment;
import edu.vassar.cmpu203.team2a.view.deptHeadView.AddDepartmentCourseFragment;
import edu.vassar.cmpu203.team2a.view.deptHeadView.AddPoolNameFragment;
import edu.vassar.cmpu203.team2a.view.deptHeadView.IPoolOptionsView;
import edu.vassar.cmpu203.team2a.view.deptHeadView.PoolOptionsFragment;
import edu.vassar.cmpu203.team2a.view.deptHeadView.RemovePoolNameFragment;
import edu.vassar.cmpu203.team2a.view.deptHeadView.IAddDeptCourseView;
import edu.vassar.cmpu203.team2a.view.IMainMenuFragment;
import edu.vassar.cmpu203.team2a.view.IMainView;
import edu.vassar.cmpu203.team2a.view.advisorView.IManageAdviseeView;
import edu.vassar.cmpu203.team2a.view.deptHeadView.IEnterPoolName;
import edu.vassar.cmpu203.team2a.view.deptHeadView.IManageCatalogueMenu;

import edu.vassar.cmpu203.team2a.view.MainMenuFragment;
import edu.vassar.cmpu203.team2a.view.MainView;
import edu.vassar.cmpu203.team2a.view.deptHeadView.IRemoveDeptCourseView;
import edu.vassar.cmpu203.team2a.view.deptHeadView.ManageCatalogueFragment;

import edu.vassar.cmpu203.team2a.view.advisorView.AdvisorMenuFrag;
import edu.vassar.cmpu203.team2a.view.advisorView.IAdvisorMenufrag;
import edu.vassar.cmpu203.team2a.view.deptHeadView.RemoveDepartmentCourseFragment;

public class ControllerActivity extends AppCompatActivity implements IAddDeptCourseView.Listener, IMainMenuFragment.Listener,  IAdvisorMenufrag.Listener, IManageAdviseeView.Listener, IManageCatalogueMenu.Listener, IDeptHeadMenu.Listener, IEnterPoolName.Listener, IRemoveDeptCourseView.Listener, IPoolOptionsView.Listener {
    private IMainView mainView;
    private CourseCatalogue courseCatalogue;
    private Major major;
    private Advisor advisor;

    private final IpersistenceFacade persistenceFacade = new FirestoreFacade();
    public Advisor getAdvisor() { return this.advisor; }
    public CourseCatalogue getCourseCatalogue(){return this.courseCatalogue;}
    public Major getMajor(){return this.major;}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FragmentFactory fragmentFactory = new AdvisingAppFragFactory(this);
        this.getSupportFragmentManager().setFragmentFactory(fragmentFactory);
        super.onCreate(savedInstanceState);
        Log.i("MainMenu","onCreate activity");
        //Create screen skeleton
       this.mainView = new MainView(this);
       this.setContentView(this.mainView.getRootView());
       // load up the course catalogue
       this.courseCatalogue = new CourseCatalogue();
       //load up the advisor
       this.advisor = new Advisor();
       //load up the major
        this.major = new Major();
       this.persistenceFacade.retrieveAdvisor(new IpersistenceFacade.DataListener<Advisor>() {
           @Override
           public void onDataRecieved(Advisor advisor) {
               ControllerActivity.this.advisor = advisor; // set the activity's advisor to the one retrieved from the database \

               Fragment currFrag = ControllerActivity.this.mainView.getCurrentFragment();
               if(currFrag instanceof IAdvisorMenufrag)((IAdvisorMenufrag)currFrag).updateMenuDisplay();
           }

           @Override
           public void onNoDataFound() {

           }
       });

        this.persistenceFacade.retrieveMajor(new IpersistenceFacade.DataListener<Major>() {
            @Override
            public void onDataRecieved(@NonNull Major major) {
                ControllerActivity.this.major = major; // set the activity's major to the one retrieved from the database \

                Fragment currFrag = ControllerActivity.this.mainView.getCurrentFragment();
                if(currFrag instanceof IPoolOptionsView)((IPoolOptionsView)currFrag).updatePoolDisplay(major);
            }

            @Override
            public void onNoDataFound() { }
        });

        this.persistenceFacade.retrieveCatalogue(new IpersistenceFacade.DataListener<CourseCatalogue>() {
            @Override
            public void onDataRecieved(@NonNull CourseCatalogue courseCatalogue) {
                ControllerActivity.this.courseCatalogue = courseCatalogue; // set the activity's catalogue to the one retrieved from the database \

                Fragment currFrag = ControllerActivity.this.mainView.getCurrentFragment();
                if(currFrag instanceof IManageCatalogueMenu)((IManageCatalogueMenu)currFrag).updateMenuDisplay(courseCatalogue);
            }

            @Override
            public void onNoDataFound() { }
        });


        if(savedInstanceState != null){
            this.advisor = (Advisor)savedInstanceState.getSerializable("Advisee");
            this.major = (Major)savedInstanceState.getSerializable("Major");
            this.courseCatalogue = (CourseCatalogue)savedInstanceState.getSerializable("Catalogue");
        }
        else{
            this.advisor = new Advisor();
            this.major = new Major();
            this.courseCatalogue = new CourseCatalogue();}
            this.mainView.displayFragment(new MainMenuFragment(this));

    }

    @Override
    public void onAddedCourse(String id, String time) {
        Log.d("AdvisingApp", "controller is handling adding a course");
        this.courseCatalogue.addCourse(id, time, null);
        this.persistenceFacade.saveCatalogue(this.courseCatalogue.get(id));
        this.onManageCatalogue();
    }

    @Override
    public void onRemovedCourse(String courseID){
        this.courseCatalogue.removeCourse(courseID);
        this.onManageCatalogue();

    }

    @Override
    public void onSelectingStudent() {

    }

    @Override
    public void onSelectingAdvisor() {
        Fragment f = new AdvisorMenuFrag(this);
        this.mainView.displayFragment(f);
    }

    @Override
    public void onSelectingHOD() {
        Fragment f = new DeptHeadMenuFragment(this);
        this.mainView.displayFragment(f);
    }


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


    @Override
    public void addAdvisee(String name, int id, int classYear) {
        this.advisor.addAdvisee(name,id,classYear,new LinkedList());
        this.persistenceFacade.saveAdvisee(this.advisor.getAdvisee(id));;
        this.onSelectingAdvisor();

    }

    @Override
    public void deleteAdvisee(int id) {
        advisor.deleteAdvisee(id);
    }



    @Override
    public void onAddCourse() {
        Fragment f = new AddDepartmentCourseFragment(this);
        this.mainView.displayFragment(f);

    }

    @Override
    public void onRemoveCourse() {
        Fragment f = new RemoveDepartmentCourseFragment(this);
        this.mainView.displayFragment(f);

    }

    @Override
    public void onManageCatalogue() {
        Fragment f = new ManageCatalogueFragment(this);
        this.mainView.displayFragment(f);
    }

    // Goes to the Pool options fragment
    @Override
    public void onManageMajor() {
        Fragment f = new PoolOptionsFragment(this);
        this.mainView.displayFragment(f);
    }

    // Goes to the Add pool fragment
    @Override
    public void onCreatePoolButton() {
        Fragment f = new AddPoolNameFragment(this);
        this.mainView.displayFragment(f);
    }

    // Goes to the remove pool fragment
    @Override
    public void onRemovePoolButton() {
        Fragment f = new RemovePoolNameFragment(this);
        this.mainView.displayFragment(f);
    }

    // Uses the create pool method to add the pool onto a list of pools
    @Override
    public void createPool(String idString) {
        major.createPool(idString);
        this.persistenceFacade.saveMajor(this.major);
        this.onManageMajor();
    }

    // Uses the remove pool method to remove the pool from a list of pools
    @Override
    public void removePool(String idString) {
        major.removePool(idString);
        this.persistenceFacade.saveMajor(this.major);
        this.onManageMajor();
    }
}