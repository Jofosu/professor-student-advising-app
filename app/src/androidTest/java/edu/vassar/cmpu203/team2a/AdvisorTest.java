package edu.vassar.cmpu203.team2a;

import static androidx.test.espresso.action.ViewActions.click;

import androidx.test.espresso.Espresso;

import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import edu.vassar.cmpu203.team2a.controller.ControllerActivity;
import edu.vassar.cmpu203.team2a.model.Advisor;

public class AdvisorTest {

    String  advisor = "prof";
    String  password = "prof";

    @org.junit.Rule
    public ActivityScenarioRule<ControllerActivity> activityRule =
            new ActivityScenarioRule<>(ControllerActivity.class);

    @org.junit.Test
    public void RegisterAdvisor(){

        //enter username and password
        Espresso.onView(ViewMatchers.withId(R.id.editTextUsername)).perform(
                ViewActions.typeText(advisor));
        Espresso.onView(ViewMatchers.withId(R.id.editTextPassword)).perform(
                ViewActions.typeText(password));
        //close keyboard and click register button
        Espresso.onView(ViewMatchers.withId(R.id.editTextPassword)).perform(
                ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.registerButton)).
                perform(click());
        //click sign in button
        Espresso.onView(ViewMatchers.withId(R.id.signInButton)).
                perform(click());

    }
    @org.junit.Test
    public void AddAdvisee(){
        RegisterAdvisor();
        Espresso.onView(ViewMatchers.withId(R.id.advisorButtton)).perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.addAdviseeButton4)).perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.editFirstName)).perform(
                ViewActions.typeText("Jude"));
        Espresso.onView(ViewMatchers.withId(R.id.editLastName)).perform(
                ViewActions.typeText("Ofosu"));
        Espresso.onView(ViewMatchers.withId(R.id.editClassYear)).perform(
                ViewActions.typeText("2023"));
        Espresso.onView(ViewMatchers.withId(R.id.editStudentId)).perform(
                ViewActions.typeText("999543211"));
        Espresso.onView(ViewMatchers.withId(R.id.adviseeMajor)).perform(
                ViewActions.typeText("CMPU"));
        Espresso.onView(ViewMatchers.withId(R.id.adviseeMajor)).perform(
                ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.endButton)).
                perform(click());

    }

    @org.junit.Test
    public void DeleteAdvisee(){
        RegisterAdvisor();
        Espresso.onView(ViewMatchers.withId(R.id.deleteAdviseeButton2)).perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.editStudentId2)).perform(
                ViewActions.typeText("999543211")
        );
        Espresso.onView(ViewMatchers.withId(R.id.editStudentId2)).perform(
                ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.button)).
                perform(click());

    }

}
