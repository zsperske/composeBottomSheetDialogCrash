package com.sperske.composebottomsheetcrash

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import com.sperske.composebottomsheetcrash.ui.MyBottomSheetDialog

/**
 * This class will reproduce a crash when attempting to show a Material Bottom Sheet that contains
 * an AbstractComposeView.
 *
 * This simulates our current setup in production which is a single activity with an XML layout, under
 * which Composables are created which can launch BottomSheetDialogs.
 *
 * We also have many BottomSheets which are launched from pure XML pages that wish to make use of "MyComposeButton"
 * in XML. Usages of an AbstractComposeView in those instances also cause the same crash seen here.
 */
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.main_activity)

    findViewById<ComposeView>(R.id.composeRoot).setContent {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
          Greeting("Android")

          val context = LocalContext.current
          Button(onClick = {
            MyBottomSheetDialog(context, findViewById(R.id.root)).show()
          }) {
            Text("Crash!")
          }
        }
      }
  }
}

@Composable
fun Greeting(name: String) {
  Text(text = "Hello $name!")
}
