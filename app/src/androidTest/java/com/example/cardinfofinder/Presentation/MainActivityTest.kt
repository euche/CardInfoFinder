package com.example.cardinfofinder.Presentation

import android.app.Activity
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.*
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.example.cardinfofinder.R

@RunWith(AndroidJUnit4::class)
class MainActivityTest{

    @Rule
    @JvmField
    //val activityRule = ActivityTestRule(MainActivity::class.java)
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

   @Test
   fun testSubmitButton(){
       //type the cardnumber
       onView(withId(R.id.card_number_input)).perform(typeText("5399834410766144"))
       //click the submit button
       onView(withId(R.id.submit_cardnumber_action_button)).perform(click())
   }


}