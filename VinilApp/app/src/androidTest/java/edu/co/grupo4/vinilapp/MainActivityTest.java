package edu.co.grupo4.vinilapp;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.logging.Logger;

import edu.co.grupo4.vinilapp.views.MainActivity;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    protected static Logger logger = Logger.getLogger(MainActivityTest.class.getName());

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityTestRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void selectCollectorOption() {
        ViewInteraction collectorButton = onView(allOf(withId(R.id.imgBtnColeccionista), isDisplayed()));
        collectorButton.perform(click());
    }

    @Test
    public void selectGuestOption() {
        ViewInteraction guestButton = onView(allOf(withId(R.id.imgBtnVisitante), isDisplayed()));
        guestButton.perform(click());
    }
}
