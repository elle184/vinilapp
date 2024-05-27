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

import edu.co.grupo4.vinilapp.views.CrearAlbumActivity;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class CrearAlbumActivityTest {

    @Rule
    public ActivityScenarioRule<CrearAlbumActivity> activityTestRule = new ActivityScenarioRule<>(CrearAlbumActivity.class);

    @Test
    public void clickAgregarButton() {
        // Interacción con el botón "Agregar"
        ViewInteraction agregarButton = onView(allOf(withId(R.id.button_agregar), isDisplayed()));
        agregarButton.perform(click());
    }
}
