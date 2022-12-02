package com.sperske.composebottomsheetcrash.ui

import android.content.Context
import android.util.AttributeSet
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.AbstractComposeView

class MyComposeButton(context: Context, attrs: AttributeSet? = null): AbstractComposeView(context, attrs) {

  @Composable
  override fun Content() {
    Button(onClick = {}) {
      Text("My Button")
    }
  }
}