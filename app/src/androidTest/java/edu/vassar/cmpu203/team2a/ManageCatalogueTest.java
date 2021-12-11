package edu.vassar.cmpu203.team2a;


import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
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
     * added to the catalogue shown on ManageCatalogue frag. Then it removes the course and checks
     * to see that the course is no longer in the catalogue
     */

    @Test
    public void testAddAndRemoveFromCatalogue() {
        //adding a course
        Espresso.onView(ViewMatchers.withId(R.id.hodButon)).perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.manageCatalogueButton)).perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.addCourse)).perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.editCourseID))
                .perform(ViewActions.typeText("CMPU20301"));
        Espresso.closeSoftKeyboard();
        Espresso.onView(ViewMatchers.withId(R.id.editStartTIme))
                .perform(ViewActions.typeText("12:30"));
        Espresso.closeSoftKeyboard();
        Espresso.onView(ViewMatchers.withId(R.id.editEndTIme))
                .perform(ViewActions.typeText("13:30"));
        Espresso.closeSoftKeyboard();
        Espresso.onView(ViewMatchers.withId(R.id.tuesday)).perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.thursday)).perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.doneButton3)).perform(click()); //create a course

        ViewInteraction listofPools = Espresso.onView(ViewMatchers.withId(R.id.listofCourses));
        listofPools.check(matches(ViewMatchers.withSubstring("CMPU20301 12:30-13:30TR")));
        // checks addition is successful

        //edit a course
        Espresso.onView(ViewMatchers.withId(R.id.addCourse)).perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.editCourseID))
                .perform(ViewActions.typeText("CMPU20301"));
        Espresso.closeSoftKeyboard();
        Espresso.onView(ViewMatchers.withId(R.id.editStartTIme))
                .perform(ViewActions.typeText("22:30"));
        Espresso.closeSoftKeyboard();
        Espresso.onView(ViewMatchers.withId(R.id.editEndTIme))
                .perform(ViewActions.typeText("23:30"));
        Espresso.closeSoftKeyboard();
        Espresso.onView(ViewMatchers.withId(R.id.tuesday)).perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.thursday)).perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.doneButton3)).perform(click()); //create a course
        listofPools.check(matches(ViewMatchers.withSubstring("CMPU20301 22:30-23:30TR")));
        Espresso.onView(ViewMatchers.withSubstring("CMPU20301 12:30-13:30TR")).check(doesNotExist());
        //expect the same course, but with different times


        //removing a course
        Espresso.onView(ViewMatchers.withId(R.id.removeCourse)).perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.enterRemoveID))
                .perform(ViewActions.typeText("CMPU20301"));// removes the course
        Espresso.closeSoftKeyboard();
        Espresso.onView(ViewMatchers.withId(R.id.removeCourseButton)).perform(click());
        Espresso.onView(ViewMatchers.withSubstring("CMPU20301 22:30-23:30TR")).check(doesNotExist());
        //checks that the course was successfully removed

    }
}
