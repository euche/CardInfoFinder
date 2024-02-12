package com.example.cardinfofinder.util

import android.content.Context
import org.junit.Assert.*
import org.junit.Before
import org.junit.*
import org.mockito.Mockito
import org.mockito.Mock
import org.hamcrest.CoreMatchers.*

class NetworkconnectivityTest{

       lateinit var SUT: Networkconnectivity

       @Mock
       lateinit var mockApplicationConntext:Context

       @Before
       fun setup(){
           SUT = Mockito.mock(Networkconnectivity::class.java)
       }

      @Test
      fun isConnectedToNetwork(){
          Mockito.`when`(SUT.isNetworkAvailable(mockApplicationConntext)).thenReturn(false)
          assertThat(SUT.isNetworkAvailable(mockApplicationConntext), `is`(false))
      }





}