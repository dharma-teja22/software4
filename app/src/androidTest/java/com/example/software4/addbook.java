package com.example.software4;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withSubstring;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class addbook {

    String STRING_TO_BE_TYPED="manish1616j";
    String STRING_TO_BE_TYPED1="manishmanish";
    @Rule
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void adminlogin() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.et1))
                .perform(typeText(STRING_TO_BE_TYPED), closeSoftKeyboard());
        onView(withId(R.id.et2))
                .perform(typeText(STRING_TO_BE_TYPED1), closeSoftKeyboard());
        onView(withId(R.id.b1)).perform(click());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void forgotpassword() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.b3)).perform(click());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.un1))
                .perform(typeText("rufuskp"), closeSoftKeyboard());

        onView(withId(R.id.gen1)).perform(click());



    }


    @Test
    public void addbook() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.et1))
                .perform(typeText(STRING_TO_BE_TYPED), closeSoftKeyboard());
        onView(withId(R.id.et2))
                .perform(typeText(STRING_TO_BE_TYPED1), closeSoftKeyboard());
        onView(withId(R.id.b1)).perform(click());
        onView(withId(R.id.upload)).perform(click());
        onView(withId(R.id.et1))
                .perform(typeText("software engineering"), closeSoftKeyboard());
        onView(withId(R.id.et2))
                .perform(typeText("3"), closeSoftKeyboard());
        onView(withId(R.id.b1)).perform(click());






        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    @Test
    public void searchaddedbook() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.et1))
                .perform(typeText(STRING_TO_BE_TYPED), closeSoftKeyboard());
        onView(withId(R.id.et2))
                .perform(typeText(STRING_TO_BE_TYPED1), closeSoftKeyboard());
        onView(withId(R.id.b1)).perform(click());
        onView(withId(R.id.upload)).perform(click());
        onView(withId(R.id.et1))
                .perform(typeText("Megatronics"), closeSoftKeyboard());
        onView(withId(R.id.et2))
                .perform(typeText("3"), closeSoftKeyboard());
        onView(withId(R.id.b1)).perform(click());

        onView(withId(R.id.search1)).perform(click());
        onView(withId(R.id.searchView))
                .perform(typeText("Me"), closeSoftKeyboard());
        onView(withSubstring("Megatronics")).perform(click());


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }








    }


