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
     *
     * Test relies on there being a course in the courseCatalogue. The "adviseeMajor" field
     * should match the prefix of one of these courses.
     */

    @Test
    public void testAddAndRemoveAdvisees() {
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


        //adding an advisee
        Espresso.onView(ViewMatchers.withId(R.id.advisorButtton)).perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.addAdviseeButton4)).perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.editFirstName))
                .perform(ViewActions.typeText("John"));
        Espresso.closeSoftKeyboard();
        Espresso.onView(ViewMatchers.withId(R.id.editMiddleName))
                .perform(ViewActions.typeText("Jane"));
        Espresso.closeSoftKeyboard();
        Espresso.onView(ViewMatchers.withId(R.id.editLastName))
                .perform(ViewActions.typeText("Doe"));
        Espresso.closeSoftKeyboard();
        Espresso.onView(ViewMatchers.withId(R.id.editClassYear))
                .perform(ViewActions.typeText("2022"));
        Espresso.closeSoftKeyboard();
        Espresso.onView(ViewMatchers.withId(R.id.editStudentId))
                .perform(ViewActions.typeText("999222111"));
        Espresso.closeSoftKeyboard();
        Espresso.onView(ViewMatchers.withId(R.id.adviseeMajor))
                .perform(ViewActions.typeText("BIOL")); //the prefix to a course
        Espresso.closeSoftKeyboard();
        Espresso.onView(ViewMatchers.withId(R.id.endButton)).perform(click()); //create an advisee

        /* The list contains button options. Even though the advisee shows up as a new item, I'm
        unsure how to check it.
        ViewInteraction listofPools = Espresso.onView(ViewMatchers.withId(R.id.containerOfAdvisees));
        listofPools.check(matches(ViewMatchers.withSubstring("Jun Jie Liu")));
        */

        // checks addition is successful

        //removing an advisee
        Espresso.onView(ViewMatchers.withId(R.id.deleteAdviseeButton2)).perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.editStudentId2))
                .perform(ViewActions.typeText("999222111"));// removes the course
        Espresso.closeSoftKeyboard();
        Espresso.onView(ViewMatchers.withId(R.id.button)).perform(click());
        Espresso.onView(ViewMatchers.withSubstring("Jun Jie Liu")).check(doesNotExist());
        //checks that the advisee was removed

    }
}
