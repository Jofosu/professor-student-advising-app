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

public class AddAndRemoveAdviseeTest {

    @org.junit.Rule
    public ActivityScenarioRule<ControllerActivity> activityRule =
            new ActivityScenarioRule<>(ControllerActivity.class);

    /**
     * First, it goes to the AdivsorMenu fragment, then adds an advisee and checks to see if they're
     * added to the containerOfAdvisees shown on AdvisorMenu frag. Then it removes them and checks
     * to see that they are no longer in the containerOfAdvisees.
     */

    @Test
    public void testAddAndRemoveAdvisees() {
        //adding an advisee
        Espresso.onView(ViewMatchers.withId(R.id.advisorButtton)).perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.addAdviseeButton4)).perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.editFirstName))
                .perform(ViewActions.typeText("Jun"));
        Espresso.closeSoftKeyboard();
        Espresso.onView(ViewMatchers.withId(R.id.editMiddleName))
                .perform(ViewActions.typeText("Jie"));
        Espresso.closeSoftKeyboard();
        Espresso.onView(ViewMatchers.withId(R.id.editLastName))
                .perform(ViewActions.typeText("Liu"));
        Espresso.closeSoftKeyboard();
        Espresso.onView(ViewMatchers.withId(R.id.editClassYear))
                .perform(ViewActions.typeText("2022"));
        Espresso.closeSoftKeyboard();
        Espresso.onView(ViewMatchers.withId(R.id.editStudentId))
                .perform(ViewActions.typeText("999516821"));
        Espresso.closeSoftKeyboard();
        Espresso.onView(ViewMatchers.withId(R.id.doneButton3)).perform(click()); //create a course

        ViewInteraction listofPools = Espresso.onView(ViewMatchers.withId(R.id.listofCourses));
        listofPools.check(matches(ViewMatchers.withSubstring("Jun Jie Liu")));
        // checks addition is successful

        //removing an advisee
        Espresso.onView(ViewMatchers.withId(R.id.deleteAdviseeButton2)).perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.editStudentId2))
                .perform(ViewActions.typeText("999516821"));// removes the course
        Espresso.closeSoftKeyboard();
        Espresso.onView(ViewMatchers.withId(R.id.button)).perform(click());
        Espresso.onView(ViewMatchers.withSubstring("Jun Jie Liu")).check(doesNotExist());
        //checks that the advisee was removed

    }
}
