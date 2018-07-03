package com.okawa.minichat.suite

import android.content.Intent
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.intent.Intents
import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.matcher.IntentMatchers.hasAction
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import com.okawa.minichat.AppTest
import com.okawa.minichat.R
import com.okawa.minichat.di.module.DatabaseModule
import com.okawa.minichat.ui.main.MainActivity
import com.okawa.minichat.utils.MockConversationTask
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Before
import java.lang.Thread.sleep
import javax.inject.Inject

@RunWith(AndroidJUnit4::class)
class ChatFragmentTest {

    companion object {
        private const val ATTACHMENT_POSITION = 3
        private const val SLEEP_INTERVAL = 1000L
    }

    @Inject
    lateinit var mockConversationTask: MockConversationTask

    private lateinit var appTest: AppTest

    private val testRule = ActivityTestRule<MainActivity>(MainActivity::class.java, true, false)

    @Before
    fun initialize() {
        retrieveAppTest()

        inject()
        clearDB()
        mockValues()

        Intents.init()
        testRule.launchActivity(null)
    }

    @Test
    fun openAttachment() {
        sleep(SLEEP_INTERVAL)
        onView(withId(R.id.rclChatContent)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(ATTACHMENT_POSITION))
        sleep(SLEEP_INTERVAL)
        onView(withId(R.id.rclChatContent)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(ATTACHMENT_POSITION, click()))
        sleep(SLEEP_INTERVAL)
        intended(hasAction(Intent.ACTION_VIEW))
    }

    @After
    fun dispose() {
        clearDB()
        unregisterMockResource()
        Intents.release()
    }

    private fun retrieveAppTest() {
        val instrumentation = InstrumentationRegistry.getInstrumentation()
        appTest = instrumentation.targetContext.applicationContext as AppTest
    }

    private fun inject() {
        appTest.appComponent.inject(this)
    }

    private fun clearDB() {
        appTest.deleteDatabase(DatabaseModule.DATABASE_NAME)
    }

    private fun mockValues() {
        mockConversationTask.mockSuccessConversation()
        mockConversationTask.register()
    }

    private fun unregisterMockResource() {
        mockConversationTask.unregister()
    }

}
