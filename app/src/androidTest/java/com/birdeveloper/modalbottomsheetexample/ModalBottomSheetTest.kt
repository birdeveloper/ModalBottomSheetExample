package com.birdeveloper.modalbottomsheetexample

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.birdeveloper.modalbottomsheetexample.screens.SimpleModalBottomSheet
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ModalBottomSheetTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun bottomSheet_opensAndClosesCorrectly() {
        composeTestRule.setContent {
            SimpleModalBottomSheet()
        }

        // Open bottom sheet
        composeTestRule.onNodeWithText("Show bottom sheet", useUnmergedTree = true).performClick()
        composeTestRule.onNodeWithText("Hello from Bottom Sheet!", useUnmergedTree = true).assertExists()

        // Close bottom sheet
        composeTestRule.onNodeWithText("Hide Bottom Sheet", useUnmergedTree = true).performClick()
        composeTestRule.onNodeWithText("Hello from Bottom Sheet!", useUnmergedTree = true).assertDoesNotExist()
    }
}