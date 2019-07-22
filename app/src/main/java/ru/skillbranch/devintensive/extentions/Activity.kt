package ru.skillbranch.devintensive.extensions

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.graphics.Rect
import kotlin.math.roundToInt

fun Activity.hideKeyboard(){
	val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
	val view = getWindow().getDecorView().findViewById(android.R.id.content) as View
	imm.hideSoftInputFromWindow(view.windowToken, 0)
	imm.showSoftInput(view, 0)
}

fun Activity.isKeyboardOpen(): Boolean {
	val rootView = window.decorView
	val visibleBounds = Rect()
	rootView.getWindowVisibleDisplayFrame(visibleBounds)
	val heightDiff = rootView.height - visibleBounds.height()
	val marginOfError = applicationContext.convertDpToPx(100F).roundToInt()
	return heightDiff > marginOfError
}

fun Activity.isKeyboardClosed(): Boolean = !isKeyboardOpen()