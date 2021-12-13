package edu.vassar.cmpu203.team2a;


import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Test;

import edu.vassar.cmpu203.team2a.controller.ControllerActivity;


/**
 * This test ensures that there is already a course (which is neccessary to test certain things,
 * like add advisees and Pools
 */
public class AdCourse {

    @org.junit.Rule
    public ActivityScenarioRule<ControllerActivity> activityRule =
            new ActivityScenarioRule<>(ControllerActivity.class);

    /**
     * First, it goes to the ManageCatalogue fragment, then adds a course and checks to see if it's
     * added to the catalogue shown on ManageCatalogue frag. Then it removes the course and checks
     * to see that the course is no longer in the catalogue
     */

    @Test
    public void addCourse() {
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

        //adding a couse
        Espresso.onView(ViewMatchers.withId(R.id.hodButton)).perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.manageCatalogueButton)).perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.addCourse)).perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.editCourseID))
                .perform(ViewActions.typeText("BIOL108"));
        Espresso.closeSoftKeyboard();
        Espresso.onView(ViewMatchers.withId(R.id.thursday)).perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.doneButton3)).perform(click()); //create a course
    }}