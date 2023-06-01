package anzila.binar.challengeenam.view

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class LoginActivityTest {

    private lateinit var loginActivity: LoginActivity

    @Before
    fun setup() {
        loginActivity = LoginActivity()
    }

    @Test
    fun emptyUsername() {
        val result = loginActivity.login("", "")
        assertTrue(result)
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
