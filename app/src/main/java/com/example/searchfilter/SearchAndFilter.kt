package com.example.searchfilter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Icon
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun SearchAndFilter(){

    var text  by remember { mutableStateOf("") }
    var dialogBox by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Blue)
                    .height(40.dp)
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    dialogBox = true
                },
                shape = CircleShape,
                containerColor = Color.Blue
            ) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = "",
                    tint = Color.White
                )


            }
        }
    )
    { innerPadding ->
        SearchBar(
            query = text,
            onQueryChange = {},
            onSearch = {},
            active = false,
            onActiveChange = {},
            modifier = Modifier.padding(innerPadding),
            leadingIcon = {
                Icon(
                    Icons.Default.Search,
                    contentDescription = ""
                )
            }

        ) { }


    }
    if(dialogBox){
        DialogBox(
            onDismiss = {dialogBox = false},
            onConfirm = {newItem ->
                dialogBox = false

            }
        )
    }

}

@Composable
fun DialogBox(onDismiss: () -> Unit,onConfirm: (String)->Unit){
    var text by remember { mutableStateOf("") }
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {Text("enter items")},
        text = {
            OutlinedTextField(
                value = text,
                onValueChange = {text = it},
                label = { Text("Item Name")}
            ) },
        confirmButton = {
            TextButton(
                onClick = {
                    if(text.isNotBlank()){
                        onConfirm(text)
                    }
                }
            ) {
                Text("Add")
            }


        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismiss()
                }
            ) {
                Text("Cancel")
            }

        }
    )



}