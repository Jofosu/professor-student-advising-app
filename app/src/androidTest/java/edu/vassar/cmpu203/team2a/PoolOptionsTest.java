package edu.vassar.cmpu203.team2a;


import static androidx.test.espresso.action.ViewActions.click;
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



/*
    @Test
    public void testAddPool() {

        Espresso.onView(ViewMatchers.withId(R.id.hodButon)).perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.manageMajorButton)).perform(click());

        Espresso.onView(ViewMatchers.withId(R.id.poolEntry))
                .perform(ViewActions.typeText("100lvl"));
        Espresso.closeSoftKeyboard();
        Espresso.onView(ViewMatchers.withId(R.id.button2)).perform(click());
        ViewInteraction listofPools = Espresso.onView(ViewMatchers.withId(R.id.listofPools));
        listofPools.check(ViewAssertions.matches(ViewMatchers.withSubstring("100lvl")));


    }

    }
