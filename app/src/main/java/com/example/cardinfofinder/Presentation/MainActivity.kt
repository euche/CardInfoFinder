package com.example.cardinfofinder.Presentation

import ApiClient
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.AppCompatButton
import com.example.cardinfofinder.R
import com.example.cardinfofinder.util.Dialogmessage
import com.google.android.material.textfield.TextInputEditText
import android.widget.Toast
import com.example.cardinfofinder.Domain.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var submitCardButton: AppCompatButton
    private lateinit var cardNumberInputText: TextInputEditText
    private val TAG: String = "Mainactivity"

    private val tDialog: Dialogmessage by lazy {
        Dialogmessage(this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        submitCardButton = findViewById(R.id.submit_cardnumber_action_button)
        cardNumberInputText = findViewById(R.id.card_number_input)

        submitButtonFunction()

    }

    private fun submitButtonFunction() {
        // dialog could be here
        submitCardButton.setOnClickListener {
            getEntryFromCardNumberField()
        }
    }

    private fun getEntryFromCardNumberField() {
        val cardNumber: String = cardNumberInputText.text.toString()
        val checkField = checkEmptyField(cardNumber)

        if (!checkField) {
            //dialog
            Toast.makeText(this, "Please enter your card number", Toast.LENGTH_SHORT).show()
        } else {
            Log.e(TAG, "First step")

            val firstSixDigitsOfCard = cardNumber.substring(0, 6)// first 6 characters of String.
            Log.e(TAG, "$firstSixDigitsOfCard second step")  // cardno. for test  539983
            // code for JSON Retrieval and consumption

            fetchApiServiceResponse(firstSixDigitsOfCard)


        }
    }

    private fun fetchApiServiceResponse(firstSixDigitsOfCard: String) {
        val call = ApiClient.apiService.fetchCardNumberResults(firstSixDigitsOfCard)

        call.enqueue(object : Callback<Result> {

            override fun onResponse(call: Call<Result>, response: Response<Result>) {
                if (response.isSuccessful) {
                    val responseCode = response.code()
                    Log.e(TAG, "$responseCode third step")
                    val responseM = response.body()
                    // Handle the retrieved post data

                    val cardBrand = responseM?.brand
                    val cardType = responseM?.cardType
                    val bank = responseM?.bank
                    val country = responseM?.countryName

                    tDialog.showDialog("$cardBrand $cardType  $bank $country")


                } else {
                    val responseErrorReturn = response.errorBody()
                    val responseErrorCode = response.code()
                    tDialog.showDialog("Error" + " " + responseErrorCode + " " + responseErrorReturn.toString())
                }
            }

            override fun onFailure(call: Call<Result>, t: Throwable) {
                // Handle failure
                tDialog.showDialog("An Error was encountered. Please try again later ")
                Log.e(
                    TAG,
                    t.message!!
                ) // the error is due to the fact that the server response is in Html

            }
        })
    }

    // check fields
    fun checkEmptyField(cardNumber: String): Boolean {
        var valid = true

        if (cardNumber.isEmpty()) {
            Toast.makeText(this, "Please enter your card number", Toast.LENGTH_SHORT).show()
            valid = false
        }
        return valid

    }

}