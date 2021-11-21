package edu.vassar.cmpu203.team2a;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import org.junit.Test;
import edu.vassar.cmpu203.team2a.controller.ControllerActivity;

public class ManageAdviseesMenuTest {

    @org.junit.Rule
    ActivityScenarioRule<ControllerActivity> activityRule =
            new ActivityScenarioRule<>(ControllerActivity.class);


    /**
     * For both methods:
     * Testing that we can navigate to the addAdvisee menu or the removeAdvisee menu from the
     * manage advisees menu using buttons
     */

    @Test
    public void testAdvisorAddAdviseeButton() {

        ViewInteraction menu = Espresso.onView(ViewMatchers.withId(R.id.adviseeListLabel));
        menu.check(matches(ViewMatchers.withText(R.string.adviseeListTextView)));
        Espresso.onView(ViewMatchers.withId(R.id.addAdvisee)).perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.textViewAdviseeInfo)).check(matches(isDisplayed()));
    }

    @Test
    public void testAdvisorRemoveAdviseeButton() {
        ViewInteraction menu = Espresso.onView(ViewMatchers.withId(R.id.adviseeListLabel));
        Espresso.onView(ViewMatchers.withId(R.id.removeAdvisee)).perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.textViewAdviseeInfo)).check(matches(isDisplayed()));
    }




}

