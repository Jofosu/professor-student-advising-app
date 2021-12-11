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

public class PoolOptionsTest {

    @org.junit.Rule
    public ActivityScenarioRule<ControllerActivity> activityRule =
            new ActivityScenarioRule<>(ControllerActivity.class);


    /**
     * First, it goes to the PoolOptions fragment, then creates a pool and checks to see if it's
     * added to the list of pools shown on PoolOptions. Then it removes the same pool and checks
     * to see that the pool is no longer in the list
     */
    @Test
    public void testAddPoolandRemovePool() {
        //adding a pool
        Espresso.onView(ViewMatchers.withId(R.id.hodButon)).perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.manageMajorButton)).perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.CreatePool)).perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.poolEntry))
                .perform(ViewActions.typeText("100lvl")); //create a pool called 100lvl
        Espresso.closeSoftKeyboard();
        Espresso.onView(ViewMatchers.withId(R.id.button2)).perform(click());
        ViewInteraction listofPools = Espresso.onView(ViewMatchers.withId(R.id.listofPools));
        listofPools.check(matches(ViewMatchers.withSubstring("100lvl")));// checks addition is successful

        //Testing adding a course to a pool. Assumes a course called CMPU10101 was previously made in the ManageCatalogue test
        //Also testing that the view pool option function works
        Espresso.onView(ViewMatchers.withId(R.id.editPoolCoursesButton)).perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.addPoolButton)).perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.poolEntry))
                .perform(ViewActions.typeText("100lvl"));
        Espresso.closeSoftKeyboard();
        Espresso.onView(ViewMatchers.withId(R.id.idEntry))
                .perform(ViewActions.typeText("CMPU10101"));
        Espresso.closeSoftKeyboard();
        Espresso.onView(ViewMatchers.withId(R.id.button3)).perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.poolEntry))
                .perform(ViewActions.typeText("100lvl"));
        Espresso.closeSoftKeyboard();
        Espresso.onView(ViewMatchers.withId(R.id.viewpoolcourses)).perform(click());
        ViewInteraction listofPoolCourse = Espresso.onView(ViewMatchers.withId(R.id.listOfPoolCourses));
        listofPoolCourse.check(matches(ViewMatchers.withSubstring("CMPU10101")));// checks addition is successful
        Espresso.onView(ViewMatchers.withId(R.id.button4)).perform(click());

        //Testing removing a pool course
        Espresso.onView(ViewMatchers.withId(R.id.editPoolCoursesButton)).perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.removePoolCourse)).perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.poolEntry))
                .perform(ViewActions.typeText("100lvl"));
        Espresso.closeSoftKeyboard();
        Espresso.onView(ViewMatchers.withId(R.id.idEntry))
                .perform(ViewActions.typeText("CMPU10101"));
        Espresso.closeSoftKeyboard();
        Espresso.onView(ViewMatchers.withId(R.id.button3)).perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.poolEntry))
                .perform(ViewActions.typeText("100lvl"));
        Espresso.closeSoftKeyboard();
        Espresso.onView(ViewMatchers.withId(R.id.viewpoolcourses)).perform(click());
        Espresso.onView(ViewMatchers.withSubstring("CMPU10101")).check(doesNotExist());
        Espresso.onView(ViewMatchers.withId(R.id.button4)).perform(click());

        //removing a pool
        Espresso.onView(ViewMatchers.withId(R.id.RemovePool)).perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.poolEntry))
                .perform(ViewActions.typeText("100lvl"));// removes the pool called 100 lvl
        Espresso.closeSoftKeyboard();
        Espresso.onView(ViewMatchers.withId(R.id.button2)).perform(click());
        Espresso.onView(ViewMatchers.withSubstring("100lvl")).check(doesNotExist());
        //checks that the pool was successfully removed



    }
}

