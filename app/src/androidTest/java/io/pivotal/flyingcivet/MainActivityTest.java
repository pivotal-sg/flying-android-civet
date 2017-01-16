package io.pivotal.flyingcivet;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void showNoActiveRun() {
        onView(withId(R.id.run_status_text))
                .check(matches(withText(R.string.no_active_runs)));
    }

    @Test
    public void clickOnStartRun_goToPlacesActivity() {
        onView(withId(R.id.start_run_button)).perform(click());

        onView(withId(R.id.coffee_places_list)).check(matches(isDisplayed()));
    }

    @Test
    public void clickOnBack_navigatesToMainActivity() {
        onView(withId(R.id.start_run_button)).perform(click());
        pressBack();

        onView(withId(R.id.run_status_text))
                .check(matches(withText(R.string.no_active_runs)));
    }
}
