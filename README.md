# composeBottomSheetDialogCrash

This project will reproduce a crash when attempting to show a Material Bottom Sheet that contains an AbstractComposeView.
 
This simulates our current setup in production which is a single activity with an XML layout, under which Composables are created which can launch BottomSheetDialogs.
 
We also have many BottomSheets which are launched from pure XML pages that wish to make use of "MyComposeButton" in XML. Usages of an AbstractComposeView in those instances also cause the same crash seen here. Therefore we can't just use the experimental BottomSheet functionality available in Compose without rewriting a significant number of Views.

Stacktrace:

java.lang.IllegalStateException: ViewTreeLifecycleOwner not found from android.widget.FrameLayout{7ec5e5f V.E...... ......I. 0,0-0,0 #7f08006f app:id/container}
                                                                                                    	at androidx.compose.ui.platform.WindowRecomposer_androidKt.createLifecycleAwareWindowRecomposer(WindowRecomposer.android.kt:349)
                                                                                                    	at androidx.compose.ui.platform.WindowRecomposer_androidKt.createLifecycleAwareWindowRecomposer$default(WindowRecomposer.android.kt:324)
                                                                                                    	at androidx.compose.ui.platform.WindowRecomposerFactory$Companion$LifecycleAware$1.createRecomposer(WindowRecomposer.android.kt:168)
                                                                                                    	at androidx.compose.ui.platform.WindowRecomposerPolicy.createAndInstallWindowRecomposer$ui_release(WindowRecomposer.android.kt:224)
                                                                                                    	at androidx.compose.ui.platform.WindowRecomposer_androidKt.getWindowRecomposer(WindowRecomposer.android.kt:299)
                                                                                                    	at androidx.compose.ui.platform.AbstractComposeView.resolveParentCompositionContext(ComposeView.android.kt:240)
                                                                                                    	at androidx.compose.ui.platform.AbstractComposeView.ensureCompositionCreated(ComposeView.android.kt:247)
                                                                                                    	at androidx.compose.ui.platform.AbstractComposeView.onAttachedToWindow(ComposeView.android.kt:279)
                                                                                                    	at android.view.View.dispatchAttachedToWindow(View.java:20479)
                                                                                                    	at android.view.ViewGroup.dispatchAttachedToWindow(ViewGroup.java:3489)
                                                                                                    	at android.view.ViewGroup.dispatchAttachedToWindow(ViewGroup.java:3496)
                                                                                                    	at android.view.ViewGroup.dispatchAttachedToWindow(ViewGroup.java:3496)
                                                                                                    	at android.view.ViewGroup.dispatchAttachedToWindow(ViewGroup.java:3496)
                                                                                                    	at android.view.ViewGroup.dispatchAttachedToWindow(ViewGroup.java:3496)
                                                                                                    	at android.view.ViewGroup.dispatchAttachedToWindow(ViewGroup.java:3496)
                                                                                                    	at android.view.ViewGroup.dispatchAttachedToWindow(ViewGroup.java:3496)
                                                                                                    	at android.view.ViewGroup.dispatchAttachedToWindow(ViewGroup.java:3496)
                                                                                                    	at android.view.ViewGroup.dispatchAttachedToWindow(ViewGroup.java:3496)
                                                                                                    	at android.view.ViewGroup.dispatchAttachedToWindow(ViewGroup.java:3496)
                                                                                                    	at android.view.ViewRootImpl.performTraversals(ViewRootImpl.java:2417)
                                                                                                    	at android.view.ViewRootImpl.doTraversal(ViewRootImpl.java:1952)
                                                                                                    	at android.view.ViewRootImpl$TraversalRunnable.run(ViewRootImpl.java:8171)
                                                                                                    	at android.view.Choreographer$CallbackRecord.run(Choreographer.java:972)
                                                                                                    	at android.view.Choreographer.doCallbacks(Choreographer.java:796)
                                                                                                    	at android.view.Choreographer.doFrame(Choreographer.java:731)
                                                                                                    	at android.view.Choreographer$FrameDisplayEventReceiver.run(Choreographer.java:957)
                                                                                                    	at android.os.Handler.handleCallback(Handler.java:938)
                                                                                                    	at android.os.Handler.dispatchMessage(Handler.java:99)
                                                                                                    	at android.os.Looper.loop(Looper.java:223)
                                                                                                    	at android.app.ActivityThread.main(ActivityThread.java:7656)
                                                                                                    	at java.lang.reflect.Method.invoke(Native Method)
                                                                                                    	at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:592)
                                                                                                    	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:947)
