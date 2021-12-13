package edu.vassar.cmpu203.team2a;


import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;


import org.junit.Test;

import edu.vassar.cmpu203.team2a.controller.ControllerActivity;

public class MainMenuTest {

    @org.junit.Rule
    public ActivityScenarioRule<ControllerActivity> activityRule =
            new ActivityScenarioRule<>(ControllerActivity.class);


    // Testing the department chair button goes to the department chair options menu
    @Test
    public void testDeptChairButton() {
        //Need to sign in first
        Espresso.onView(ViewMatchers.withId(R.id.editTextUsername)).
                perform(ViewActions.typeText("Junjie"));
        Espresso.closeSoftKeyboard();
        Espresso.onView(ViewMatchers.withId(R.id.editTextPassword)).
                perform(ViewActions.typeText("abcd"));
        Espresso.closeSoftKeyboard();
        Espresso.onView(ViewMatchers.withId(R.id.registerButton)).perform(click());
        // double-checking user is registered in case it's deleted from firebase
        // Also tests the register button first
        Espresso.onView(ViewMatchers.withId(R.id.signInButton)).perform(click());

        //finding the right view
        ViewInteraction menu = Espresso.onView(ViewMatchers.withId(R.id.welcomeMessageTextView));
        //checking that we are at the main menu
        menu.check(matches(ViewMatchers.withText(R.string.welcome_message)));
        //clicking into the department chair options menu
        Espresso.onView(ViewMatchers.withId(R.id.hodButton)).perform(click());
        //checking that we are at the department chair options menu
        Espresso.onView(ViewMatchers.withId(R.id.manageCatalogueButton)).check(matches(isDisplayed()));
    }

    /*
    Need to make a student screen
    @Test
    public void testStudentButton() {
        ViewInteraction menu = Espresso.onView(ViewMatchers.withId(R.id.welcomeMessage));
        Espresso.onView(ViewMatchers.withId(R.id.studentButton)).perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.???)).check(matches(isDisplayed()));
    }
     */


    /**
     *      Testing the advisor button goes to the manage advisees menu
     */
    @Test
    public void testAdvisorButton() {
        //Need to sign in first
        Espresso.onView(ViewMatchers.withId(R.id.editTextUsername)).
                perform(ViewActions.typeText("Junjie"));
        Espresso.closeSoftKeyboard();
        Espresso.onView(ViewMatchers.withId(R.id.editTextPassword)).
                perform(ViewActions.typeText("abcd"));
        Espresso.closeSoftKeyboard();
        Espresso.onView(ViewMatchers.withId(R.id.registerButton)).perform(click());
        // double-checking user is registered in case it's deleted from firebase
        // Also tests the register button first
        Espresso.onView(ViewMatchers.withId(R.id.signInButton)).perform(click());

        Espresso.onView(ViewMatchers.withId(R.id.advisorButtton)).perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.addAdviseeButton4)).check(matches(isDisplayed()));
    }
}
