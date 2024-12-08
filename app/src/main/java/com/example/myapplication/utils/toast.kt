package com.example.myapplication.utils

import android.content.Context
import android.widget.Toast


fun Context.toast(message: CharSequence, toastLength: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(this, message, toastLength).show()