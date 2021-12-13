package edu.vassar.cmpu203.team2a.controller;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;

import java.util.ArrayList;

import edu.vassar.cmpu203.team2a.model.Advisor;
import edu.vassar.cmpu203.team2a.model.Course;
import edu.vassar.cmpu203.team2a.model.CourseCatalogue;
import edu.vassar.cmpu203.team2a.model.Major;
import edu.vassar.cmpu203.team2a.model.Pool;
import edu.vassar.cmpu203.team2a.model.User;
import edu.vassar.cmpu203.team2a.persistence.FirestoreFacade;
import edu.vassar.cmpu203.team2a.persistence.IpersistenceFacade;
import edu.vassar.cmpu203.team2a.view.DeptHeadMenuFragment;
import edu.vassar.cmpu203.team2a.view.IDeptHeadMenu;
import edu.vassar.cmpu203.team2a.view.IMainMenuFragment;
import edu.vassar.cmpu203.team2a.view.IMainView;
import edu.vassar.cmpu203.team2a.view.MainMenuFragment;
import edu.vassar.cmpu203.team2a.view.MainView;
import edu.vassar.cmpu203.team2a.view.advisorView.AddAdviseeViewFragment;
import edu.vassar.cmpu203.team2a.view.advisorView.AdvisorMenuFrag;
import edu.vassar.cmpu203.team2a.view.advisorView.DeleteAdviseeViewFragment;
import edu.vassar.cmpu203.team2a.view.advisorView.IAdviseeInfoView;
import edu.vassar.cmpu203.team2a.view.advisorView.IAdvisorMenuView;
import edu.vassar.cmpu203.team2a.view.advisorView.IManageAdviseeView;
import edu.vassar.cmpu203.team2a.view.authorizeView.AuthFragment;
import edu.vassar.cmpu203.team2a.view.authorizeView.IAuthView;
import edu.vassar.cmpu203.team2a.view.deptHeadView.AddDepartmentCourseFragment;
import edu.vassar.cmpu203.team2a.view.deptHeadView.AddPoolCourseFragment;
import edu.vassar.cmpu203.team2a.view.deptHeadView.AddPoolNameFragment;
import edu.vassar.cmpu203.team2a.view.deptHeadView.EditPreqFragment;
import edu.vassar.cmpu203.team2a.view.deptHeadView.IAddDeptCourseView;
import edu.vassar.cmpu203.team2a.view.deptHeadView.IEditPoolCourse;
import edu.vassar.cmpu203.team2a.view.deptHeadView.IEditPreq;
import edu.vassar.cmpu203.team2a.view.deptHeadView.IEnterPoolName;
import edu.vassar.cmpu203.team2a.view.deptHeadView.IManageCatalogueMenu;
import edu.vassar.cmpu203.team2a.view.deptHeadView.IManagePoolsFragment;
import edu.vassar.cmpu203.team2a.view.deptHeadView.IPoolOptionsView;
import edu.vassar.cmpu203.team2a.view.deptHeadView.IRemoveDeptCourseView;
import edu.vassar.cmpu203.team2a.view.deptHeadView.ManageCatalogueFragment;
import edu.vassar.cmpu203.team2a.view.deptHeadView.ManagePoolsFragment;
import edu.vassar.cmpu203.team2a.view.deptHeadView.PoolOptionsFragment;
import edu.vassar.cmpu203.team2a.view.deptHeadView.RemoveDepartmentCourseFragment;
import edu.vassar.cmpu203.team2a.view.deptHeadView.RemovePoolCourseFragment;
import edu.vassar.cmpu203.team2a.view.deptHeadView.RemovePoolNameFragment;
import edu.vassar.cmpu203.team2a.view.deptHeadView.ViewPoolCourses;

public class ControllerActivity extends AppCompatActivity implements IAddDeptCourseView.Listener,
        IMainMenuFragment.Listener, IAdvisorMenuView.Listener, IManageAdviseeView.Listener,
        IManageCatalogueMenu.Listener, IDeptHeadMenu.Listener, IEnterPoolName.Listener,
        IRemoveDeptCourseView.Listener, IPoolOptionsView.Listener, IEditPreq.Listener, IAuthView.Listener
        , IManagePoolsFragment.Listener, IEditPoolCourse.Listener, IAdviseeInfoView.Listener {
    public IMainView getMainView() {
        return mainView;
    }

    public IpersistenceFacade getPersistenceFacade() {
        return persistenceFacade;
    }

    private IMainView mainView;
    private CourseCatalogue courseCatalogue;
    private Major major;
    private Advisor advisor;
    public String sessionUsername;


    private final IpersistenceFacade persistenceFacade = new FirestoreFacade();

    public Advisor getAdvisor() {
        return this.advisor;
    }
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
           public void onDataReceived(Advisor advisor) {
               ControllerActivity.this.advisor = advisor; // set the activity's advisor to the one retrieved from the database \
               Fragment currFrag = ControllerActivity.this.mainView.getCurrentFragment();
               if (currFrag instanceof IAdvisorMenuView)
                   ((IAdvisorMenuView) currFrag).updateMenuDisplay();
           }

           @Override
           public void onNoDataFound() {

           }
       });

       this.persistenceFacade.retrieveMajor(new IpersistenceFacade.DataListener<Major>() {
            @Override
            public void onDataReceived(@NonNull Major major) {
                ControllerActivity.this.major = major; // set the activity's major to the one retrieved from the database \

                Fragment currFrag = ControllerActivity.this.mainView.getCurrentFragment();
                if(currFrag instanceof IPoolOptionsView)((IPoolOptionsView)currFrag).updatePoolDisplay(major);
            }

            @Override
            public void onNoDataFound() { }
        });

        this.persistenceFacade.retrieveCatalogue(new IpersistenceFacade.DataListener<CourseCatalogue>() {
            @Override
            public void onDataReceived(@NonNull CourseCatalogue courseCatalogue) {
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
            this.mainView.displayFragment(new AuthFragment(this));

    }

    @Override
    public void onAddedCourse(String id, String time) {
        Log.d("AdvisingApp", "controller is handling adding a course");
        ArrayList<String> courses = new ArrayList<>();
        courses.add("");
        if(courseCatalogue.inCatalogue(id)) {
                this.courseCatalogue.editTime(id, time);
                this.persistenceFacade.editCatalogue(this.courseCatalogue.get(id));
        }else {
            this.courseCatalogue.addCourse(id, time, courses);
            this.persistenceFacade.saveCatalogue(this.courseCatalogue.get(id));

        }
        this.onManageCatalogue();
    }

    @Override
    public void onRemovedCourse(String courseID){
        this.persistenceFacade.deleteCatalogue(this.courseCatalogue.get(courseID));
        this.courseCatalogue.removeCourse(courseID);
        this.onManageCatalogue();

    }

    @Override
    public void onSelectingStudent() {

    }

    //redirects to the advisor menu
    @Override
    public void onSelectingAdvisor() {
        Fragment f = new AdvisorMenuFrag(this);
        this.mainView.displayFragment(f);
    }

    //redirects to the department head menu
    @Override
    public void onSelectingHOD() {
        Fragment f = new DeptHeadMenuFragment(this);
        this.mainView.displayFragment(f);
    }

    //redirects to the add advisee menu
    @Override
    public void onSelectingAddAdvisee() {
        Fragment f = new AddAdviseeViewFragment(this);
        this.mainView.displayFragment(f);

    }

    //redirects to the remove advisee menu
    @Override
    public void onSelectingDeleteAdvisee() {
        Fragment f = new DeleteAdviseeViewFragment(this);
        this.mainView.displayFragment(f);
    }


    /**
     * @param name
     * @param id
     * @param classYear Adds an advisee to the list of advisees an Advisor has
     */
    @Override
    public void addAdvisee(String name, int id, int classYear, String major) {
        this.advisor.addAdvisee(name, id, classYear, new ArrayList(), sessionUsername, major);
        this.persistenceFacade.saveAdvisee(this.advisor.getAdvisee(id));
        this.onSelectingAdvisor();

    }

    /**
     * @param id An advisee's id
     *           Removes advisee from the list of advisees an Advisor has
     */
    @Override
    public void deleteAdvisee(int id) {

        this.persistenceFacade.removeAdvisee(this.advisor.getAdvisee(id));
        this.advisor.deleteAdvisee(id);
        this.onSelectingAdvisor();
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
    public void onEditPreq(){
        Fragment f = new EditPreqFragment(this);
        this.mainView.displayFragment(f);
    }

    @Override
    public void editPreq(String preqTarget, String preqString){
            if(courseCatalogue.inCatalogue(preqString) & courseCatalogue.inCatalogue(preqTarget)){
                Course target = courseCatalogue.get(preqString);
                Course preq = courseCatalogue.get(preqTarget);
                if(!target.getPrerequisites().contains(preq.getId())) {
                    target.getPrerequisites().add(preq.getId());
                }else{
                    target.getPrerequisites().remove(preq.getId());
                }

                this.persistenceFacade.editPreq(target);
                this.onManageCatalogue();
            }


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

    @Override
    public void onEditPoolCoursesButton() {
       Fragment f = new ManagePoolsFragment(this);
       this.mainView.displayFragment(f);
    }

    // Uses the create pool method to add the pool onto a list of pools
    @Override
    public void createPool(String idString) {
            major.createPool(idString);
            this.persistenceFacade.savePool(this.major.getAPool(idString));
            this.onManageMajor();
    }

    @Override
    public void onBackToManagePools() {
        Fragment f = new PoolOptionsFragment(this);
        this.mainView.displayFragment(f);
    }

    // Uses the remove pool method to remove the pool from a list of pools
    @Override
    public void removePool(String idString) {
        major.removePool(idString);
        Pool p = new Pool (idString);
        this.persistenceFacade.removePool(p);
        this.onManageMajor();
    }

    // Authentication Listener implementation
    @Override
    public void onRegister(String username, String password, IAuthView authView) {
         User user = new User(username, password);
        sessionUsername = username;
        this.persistenceFacade.createUserIfNotExists(user, new IpersistenceFacade.BinaryResultListener() {
            @Override
            public void onYesResult() { authView.onRegisterSuccess(); }

            @Override
            public void onNoResult() { authView.onUserAlreadyExists(); }
        });
    }

    @Override
    public void onSignInAttempt(String username, String password, IAuthView authView) {
        sessionUsername = username;
          this.persistenceFacade.retrieveUser(username, new IpersistenceFacade.DataListener<User>() {
            @Override
            public void onDataReceived(@NonNull User user) {
                if (user.validatePassword(password)){
                    ControllerActivity.this.mainView.displayFragment(new MainMenuFragment(ControllerActivity.this));
                } else authView.onInvalidCredentials();
            }

            @Override
            public void onNoDataFound() {
                authView.onInvalidCredentials();
            }
        });
    }


    @Override
    public void onRemovePoolCourse() {
        Fragment f = new RemovePoolCourseFragment(this);
        this.mainView.displayFragment(f);
    }

    @Override
    public void onAddPoolCourse() {
        Fragment f = new AddPoolCourseFragment(this);
        this.mainView.displayFragment(f);
    }

    @Override
    public void onViewPoolCourses(String idString) {
        if (major.hasPool(idString)) {
            Fragment f = new ViewPoolCourses(this, idString);
            this.mainView.displayFragment(f);
        }

    }

    //this is checking that both the course and pool exist, before removing the course from the pool
    @Override
    public void removePoolCourseController(String idString, String poolName) {
        if (this.courseCatalogue.inCatalogue(idString) && major.hasPool(poolName)){
            major.getAPool(poolName).removePoolCourse(this.courseCatalogue.get(idString));
            this.persistenceFacade.savePool(this.getMajor().getAPool(poolName));
            Fragment f = new ManagePoolsFragment(this);
            this.mainView.displayFragment(f);
        }
        Fragment f = new ManagePoolsFragment(this);
        this.mainView.displayFragment(f);
    }

    //this is checking that both the course and pool exist, before adding the course to the pool
    @Override
    public void addPoolCourseController(String idString, String poolName) {
        if (this.courseCatalogue.inCatalogue(idString) && major.hasPool(poolName)){
            major.getAPool(poolName).addPoolCourse(this.courseCatalogue.get(idString));
            this.persistenceFacade.savePool(this.getMajor().getAPool(poolName));
            Fragment f = new ManagePoolsFragment(this);
            this.mainView.displayFragment(f);
        }
        Fragment f = new ManagePoolsFragment(this);
        this.mainView.displayFragment(f);
    }
}
