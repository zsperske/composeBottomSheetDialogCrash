package com.sperske.composebottomsheetcrash.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.sperske.composebottomsheetcrash.R

class MyBottomSheetDialog(context: Context, parent: ViewGroup): BottomSheetDialog(context) {

  init {
    setContentView(LayoutInflater.from(context).inflate(R.layout.bottom_sheet, parent, false))
  }

}