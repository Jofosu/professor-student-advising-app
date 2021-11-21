package edu.vassar.cmpu203.team2a;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import android.view.View;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import org.junit.Test;
import edu.vassar.cmpu203.team2a.controller.ControllerActivity;

public class ManageAdviseesMenuTest {

    @org.junit.Rule
    ActivityScenarioRule<ControllerActivity> activityRule =
            new ActivityScenarioRule<>(ControllerActivity.class);


    @Test
    public void testDeptChairButton() {

        ViewInteraction menu = Espresso.onView(ViewMatchers.withId(R.id.adviseeListTextView));
        menu.check(matches(ViewMatchers.withText(R.string.welcome_message)));
        Espresso.onView(ViewMatchers.withId(R.id.hodButon)).perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.manageCoursesButton)).check(matches(isDisplayed()));
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
    @Test
    public void testAdvisorButton() {
        ViewInteraction menu = Espresso.onView(ViewMatchers.withId(R.id.welcomeMessage));
        Espresso.onView(ViewMatchers.withId(R.id.advisorButtton)).perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.adviseeListTextView)).check(matches(isDisplayed()));
    }




}

