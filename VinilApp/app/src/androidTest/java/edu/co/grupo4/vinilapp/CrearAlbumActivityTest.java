package edu.co.grupo4.vinilapp;
import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import org.junit.Rule;
import org.junit.Test;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
public class CrearAlbumActivityTest {
    @Rule
    public ActivityScenarioRule<CrearAlbumActivity> activityScenarioRule =
            new ActivityScenarioRule<>(CrearAlbumActivity.class);

    @Test
    public void clickButton_AgregaAlbum() {
        // Hace clic en el botón con ID button_agregar
        Espresso.onView(ViewMatchers.withId(R.id.button_agregar))
                .perform(ViewActions.click());
    }
}
