package anzila.binar.challengeenam.view

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import anzila.binar.challengeenam.R
import org.hamcrest.CoreMatchers
import org.junit.runner.RunWith
import org.hamcrest.CoreMatchers.endsWith
import org.hamcrest.CoreMatchers.not
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

@RunWith(AndroidJUnit4::class)
class RegisterActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(RegisterActivity::class.java)
//bisa
    @Test
    fun testRegisterButtonClicked() {
        onView(withId(R.id.btnReg)).perform(click())
    }
//bisa
    @Test
    fun testEmptyFieldsValidation() {
        onView(withId(R.id.btnReg)).perform(click())
        onView(withText(endsWith("Empty Fields Are not Allowed !!")))
            .inRoot(not(RootMatchers.isPlatformPopup()))
            .check(matches(isDisplayed()))
    }
//bisa
    @Test
    fun testPasswordMismatchValidation() {
        onView(withId(R.id.etUnameReg)).perform(typeText("username"), closeSoftKeyboard())
        onView(withId(R.id.etPassReg)).perform(typeText("password"), closeSoftKeyboard())
        onView(withId(R.id.etRepass)).perform(typeText("different_password"), closeSoftKeyboard())
        onView(withId(R.id.btnReg)).perform(click())
        onView(withText("Password is not matching"))
            .inRoot(CoreMatchers.not(RootMatchers.isPlatformPopup()))
            .check(matches(isDisplayed()))
    }
}