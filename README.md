# composeBottomSheetDialogCrash

This project will reproduce a crash when attempting to show a Material Bottom Sheet that contains an AbstractComposeView.
 
This simulates our current setup in production which is a single activity with an XML layout, under which Composables are created which can launch BottomSheetDialogs.
 
We also have many BottomSheets which are launched from pure XML pages that wish to make use of "MyComposeButton" in XML. Usages of an AbstractComposeView in those instances also cause the same crash seen here. Therefore we can't just use the experimental BottomSheet functionality available in Compose without rewriting a significant number of Views.
