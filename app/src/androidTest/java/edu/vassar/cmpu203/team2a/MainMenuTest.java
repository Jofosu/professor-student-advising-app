package edu.vassar.cmpu203.team2a;


import android.view.View;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Test;

import edu.vassar.cmpu203.team2a.controller.ControllerActivity;

public class MainMenuTest {

    @org.junit.Rule
    ActivityScenarioRule<ControllerActivity> activityRule =
            new ActivityScenarioRule<>(ControllerActivity.class);


    @Test
    public void testMenuItems() {

        ViewInteraction menu = Espresso.onView(ViewMatchers.withId(R.id.welcomeMessage));

        menu.check(ViewAssertions.matches(ViewMatchers.withText(R.string.welcome_message)));

        ViewInteraction menu = Espresso.onView(ViewMatchers.withId(R.id.welcomeMessage))
                .perform(ViewActions.click(hodButon));



    }


}

