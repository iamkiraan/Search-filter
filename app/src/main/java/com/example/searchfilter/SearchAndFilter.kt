package com.example.searchfilter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun SearchAndFilter(){

    val text  by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            Box(
                modifier = Modifier.fillMaxWidth()
                    .background(Color.Blue)
                    .height(40.dp)
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
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

}