package anzila.binar.challengeenam.view


import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.isPlatformPopup
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import anzila.binar.challengeenam.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.tasks.Tasks
import org.hamcrest.CoreMatchers.not
import org.junit.Assert.*

class LoginActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun loginWithValidCredentials_shouldStartHomeActivity() {
        onView(withId(R.id.etUnameLog)).perform(typeText("example@gmail.com"))
        onView(withId(R.id.etPassLog)).perform(typeText("password123"))
        onView(withId(R.id.btnLogin)).perform(click())

        // Verifikasi apakah HomeActivity telah dimulai
        onView(withId(R.id.layout_home)).check(matches(isDisplayed()))
    }

    //bisa
    @Test
    fun loginWithEmptyCredentials_shouldShowToast() {
        onView(withId(R.id.btnLogin)).perform(click())

        // Verifikasi apakah Toast dengan pesan yang sesuai ditampilkan
        onView(withText("Empty Fields Are not Allowed !!"))
            .inRoot(not(isPlatformPopup()))
            .check(matches(isDisplayed()))
    }

    @Test
    fun signInWithGoogle_shouldStartHomeActivity() {
        onView(withId(R.id.btnGoogle)).perform(click())

        // Verifikasi apakah HomeActivity telah dimulai
        onView(withId(R.id.layout_home)).check(matches(isDisplayed()))
    }
}

//    @get:Rule
//    val activityRule = ActivityScenarioRule(LoginActivity::class.java)
//
//    @Test
//    fun emptyusername() {
//        activityRule.scenario.onActivity { activity ->
//            activity.runOnUiThread {
//                val result = activity.login("jeje@gmail.com", "")
//                assertTrue(result)
//            }
//        }
//    }
//}
