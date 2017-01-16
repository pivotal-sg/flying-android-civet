package io.pivotal.flyingcivet;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;

@RunWith(AndroidJUnit4.class)
public class ShopSelectionActivityTest {
    @Rule
    public ActivityTestRule<ShopSelectionActivity> mActivityRule = new ActivityTestRule<>(
            ShopSelectionActivity.class);

    @Test
    public void showListOfShops() {
        assertTextAtIndex(0, "Toast Box");
        assertTextAtIndex(1, "The Working Capitol");
    }

    private void assertTextAtIndex(int index, String text) {
        onData(anything())
                .inAdapterView(withId(R.id.coffee_places_list))
                .atPosition(index)
                .check(matches(withText(text)));
    }
}
