package edu.vassar.cmpu203.team2a;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import static com.google.firebase.firestore.util.Assert.fail;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;


import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.util.Assert;

import org.junit.Test;

import edu.vassar.cmpu203.team2a.controller.ControllerActivity;


public class AuthTest {

    @org.junit.Rule
    public ActivityScenarioRule<ControllerActivity> activityRule
            = new ActivityScenarioRule<>(ControllerActivity.class);

    @org.junit.Test
    public void testAuthentication(){

        //enter username and password
        Espresso.onView(ViewMatchers.withId(R.id.editTextUsername)).perform(
                ViewActions.typeText("Advisor1"));
        Espresso.onView(ViewMatchers.withId(R.id.editTextPassword)).perform(
                ViewActions.typeText("password1"));
        //close keyboard and click register button
        Espresso.onView(ViewMatchers.withId(R.id.editTextPassword)).perform(
                ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.registerButton)).
                perform(ViewActions.click());
        //click sign in button
        Espresso.onView(ViewMatchers.withId(R.id.signInButton)).
                perform(ViewActions.click());

    }


}
