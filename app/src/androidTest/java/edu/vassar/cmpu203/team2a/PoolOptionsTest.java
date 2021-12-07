package edu.vassar.cmpu203.team2a;

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
    ActivityScenarioRule<ControllerActivity> activityRule =
            new ActivityScenarioRule<>(ControllerActivity.class);


    // Testing the department chair button goes to the department chair options menu
    @Test
    public void testAddingAdvisee() {

    }
}
