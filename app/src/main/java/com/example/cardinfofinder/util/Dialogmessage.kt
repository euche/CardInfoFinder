package com.example.cardinfofinder.util

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Context
import android.content.DialogInterface

class Dialogmessage(c: Context) {

    private val message: String = "Cardinfofinder"
    private val pd = ProgressDialog(c)
    private val builder = AlertDialog.Builder(c)

    private val positiveButtonClick = { dialog: DialogInterface, which: Int ->
        dialog.dismiss()
    }

    fun showDialog(s: String) {
        builder.setTitle(message)
        builder.setMessage(s)
        builder.setPositiveButton(
            "OK",
            DialogInterface.OnClickListener(function = positiveButtonClick)
        )
        builder.show()
    }

    fun showProgressDialog() {
        pd.setMessage("Loading, Please wait..")
        pd.show()
    }

    fun dismissDialog() {
        if (pd.isShowing) {
            pd.dismiss()
        }
    }


}