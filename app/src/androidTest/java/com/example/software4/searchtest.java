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
public class searchtest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void searchbutton() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.et1))
                .perform(typeText("rufuskp"), closeSoftKeyboard());
        onView(withId(R.id.et2))
                .perform(typeText("rufuskp24"), closeSoftKeyboard());
        onView(withId(R.id.b1)).perform(click());
        onView(withId(R.id.search)).perform(click());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void logout() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.et1))
                .perform(typeText("rufuskp"), closeSoftKeyboard());
        onView(withId(R.id.et2))
                .perform(typeText("rufuskp24"), closeSoftKeyboard());
        onView(withId(R.id.b1)).perform(click());
        onView(withId(R.id.logout)).perform(click());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void selectbook() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.et1))
                .perform(typeText("rufuskp"), closeSoftKeyboard());
        onView(withId(R.id.et2))
                .perform(typeText("rufuskp24"), closeSoftKeyboard());
        onView(withId(R.id.b1)).perform(click());
        onView(withId(R.id.search)).perform(click());
        onView(withId(R.id.searchView))
                .perform(typeText("p"), closeSoftKeyboard());
        onView(withSubstring("Power System")).perform(click());




        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void takebook() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.et1))
                .perform(typeText("rufuskp"), closeSoftKeyboard());
        onView(withId(R.id.et2))
                .perform(typeText("rufuskp24"), closeSoftKeyboard());
        onView(withId(R.id.b1)).perform(click());
        onView(withId(R.id.search)).perform(click());
        onView(withId(R.id.searchView))
                .perform(typeText("power system"), closeSoftKeyboard());
        onView(withSubstring("Power System")).perform(click());
        onView(withId(R.id.tb)).perform(click());



        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void viewcart() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.et1))
                .perform(typeText("rufuskp"), closeSoftKeyboard());
        onView(withId(R.id.et2))
                .perform(typeText("rufuskp24"), closeSoftKeyboard());
        onView(withId(R.id.b1)).perform(click());
        onView(withId(R.id.search)).perform(click());
        onView(withId(R.id.searchView))
                .perform(typeText("power system"), closeSoftKeyboard());
        onView(withSubstring("Power System")).perform(click());
        onView(withId(R.id.tb)).perform(click());
        onView(withId(R.id.gc)).perform(click());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void returnbook1() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.et1))
                .perform(typeText("rufuskp"), closeSoftKeyboard());
        onView(withId(R.id.et2))
                .perform(typeText("rufuskp24"), closeSoftKeyboard());
        onView(withId(R.id.b1)).perform(click());
        onView(withId(R.id.search)).perform(click());
        onView(withId(R.id.searchView))
                .perform(typeText("power system"), closeSoftKeyboard());
        onView(withSubstring("Power System")).perform(click());
        onView(withId(R.id.tb)).perform(click());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        onView(withId(R.id.gc)).perform(click());
        onView(withId(R.id.br1)).perform(click());
        onView(withId(R.id.gh)).perform(click());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void returnbook() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.et1))
                .perform(typeText("rufuskp"), closeSoftKeyboard());
        onView(withId(R.id.et2))
                .perform(typeText("rufuskp24"), closeSoftKeyboard());
        onView(withId(R.id.b1)).perform(click());
        onView(withId(R.id.search)).perform(click());
        onView(withId(R.id.searchView))
                .perform(typeText("power system"), closeSoftKeyboard());
        onView(withSubstring("Power System")).perform(click());
        onView(withId(R.id.gc)).perform(click());
        onView(withId(R.id.br1)).perform(click());
        onView(withId(R.id.gh)).perform(click());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
