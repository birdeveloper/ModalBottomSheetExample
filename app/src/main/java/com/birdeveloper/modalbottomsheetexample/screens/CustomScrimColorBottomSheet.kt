package com.birdeveloper.modalbottomsheetexample.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomScrimColorBottomSheet(
    paddingValues: androidx.compose.foundation.layout.PaddingValues
) {
    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxWidth().padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(onClick = { showBottomSheet = true }) {
            Text("Open Sheet with Custom Scrim")
        }

        if (showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = { showBottomSheet = false },
                sheetState = sheetState,
                scrimColor = Color(0xAAFF4081) // Pink transparent scrim
            ) {
                // Sheet content
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(text = "Custom scrim color makes the sheet stand out!")
                    Button(onClick = {
                        coroutineScope.launch { sheetState.hide() }
                            .invokeOnCompletion {
                                showBottomSheet = false
                            }
                    }) {
                        Text("Close Bottom Sheet")
                    }
                }
            }
        }
    }
}