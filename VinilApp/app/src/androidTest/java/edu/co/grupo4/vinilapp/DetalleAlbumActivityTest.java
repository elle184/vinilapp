package edu.co.grupo4.vinilapp;
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
public class DetalleAlbumActivityTest {

    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(DetalleAlbumActivity::class.java)

    @Test
    fun clickAgregarTracksButton_opensTrackActivity() {
        Espresso.onView(ViewMatchers.withId(R.id.verTracks)).perform(ViewActions.click())
    }
}
