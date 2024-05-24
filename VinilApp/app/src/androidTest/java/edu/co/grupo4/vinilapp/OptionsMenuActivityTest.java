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

import edu.co.grupo4.vinilapp.views.MainActivity;
import edu.co.grupo4.vinilapp.views.OptionsMenu;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class OptionsMenuActivityTest {

    @Rule
    public ActivityScenarioRule<OptionsMenu> omActivityTestRule = new ActivityScenarioRule<>(OptionsMenu.class);

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityTestRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void selectAlbumOption() {
        ViewInteraction guestOptionButton = onView(allOf(withId(R.id.imgBtnVisitante), isDisplayed()));
        guestOptionButton.perform(click());

        ViewInteraction albumOptionButton = onView(allOf(withId(R.id.btnListAlbum), isDisplayed()));
        albumOptionButton.perform(click());
    }

    @Test
    public void selectMusiciansOption() {
        ViewInteraction guestOptionButton = onView(allOf(withId(R.id.imgBtnVisitante), isDisplayed()));
        guestOptionButton.perform(click());

        ViewInteraction musicianOptionButton = onView(allOf(withId(R.id.btnListaArtistas), isDisplayed()));
        musicianOptionButton.perform(click());
    }

    @Test
    public void selectCollectorsOption() {
        ViewInteraction albumOptionButton = onView(allOf(withId(R.id.imgBtnVisitante), isDisplayed()));
        albumOptionButton.perform(click());

        ViewInteraction musicianOptionButton = onView(allOf(withId(R.id.btnListColeccionista), isDisplayed()));
        musicianOptionButton.perform(click());
    }
}
