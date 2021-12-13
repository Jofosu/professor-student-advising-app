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

public class ManageCatalogueTest {

    @org.junit.Rule
    public ActivityScenarioRule<ControllerActivity> activityRule =
            new ActivityScenarioRule<>(ControllerActivity.class);

    /**
     * First, it goes to the ManageCatalogue fragment, then adds a course and checks to see if it's
     * added to the catalogue shown on ManageCatalogue frag. Then edits it.
     * Then it removes the course and checks to see that the course is no longer in the catalogue
     */

    @Test
    public void testAddAndRemoveFromCatalogue() {
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
                .perform(ViewActions.typeText("BIOL106"));
        Espresso.closeSoftKeyboard();
        Espresso.onView(ViewMatchers.withId(R.id.thursday)).perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.doneButton3)).perform(click()); //create a course

        ViewInteraction listofPools = Espresso.onView(ViewMatchers.withId(R.id.listofCourses));
        listofPools.check(matches(ViewMatchers.withSubstring("BIOL106 F")));
        // checks addition is successful

        //edit a course
        Espresso.onView(ViewMatchers.withId(R.id.addCourse)).perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.editCourseID))
                .perform(ViewActions.typeText("BIOL106"));
        Espresso.closeSoftKeyboard();
        Espresso.onView(ViewMatchers.withId(R.id.friday)).perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.doneButton3)).perform(click()); //create a course
        listofPools.check(matches(ViewMatchers.withSubstring("BIOL106 S")));
        //expect the same course, but with  a different semester

        //Adding a prereq to course
        Espresso.onView(ViewMatchers.withId(R.id.editPreqButton)).perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.enterPreqTarget))
                .perform(ViewActions.typeText("BIOL108"));
        Espresso.closeSoftKeyboard();
        Espresso.onView(ViewMatchers.withId(R.id.enterPreq))
                .perform(ViewActions.typeText("BIOL106"));
        Espresso.closeSoftKeyboard();
        Espresso.onView(ViewMatchers.withId(R.id.enterPreqButton)).perform(click());
        listofPools.check(matches(ViewMatchers.withSubstring("BIOL106")));
        //expect BIOL106 to show up (which indicates it's a prereq and the test worked

        //removing a course
        Espresso.onView(ViewMatchers.withId(R.id.removeCourse)).perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.enterRemoveID))
                .perform(ViewActions.typeText("BIOL106"));// removes the course
        Espresso.closeSoftKeyboard();
        Espresso.onView(ViewMatchers.withId(R.id.removeCourseButton)).perform(click());
        Espresso.onView(ViewMatchers.withSubstring("BIOL106 S")).check(doesNotExist());
        //checks that the course was successfully removed

    }
}
