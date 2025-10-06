package com.example.shoppinglist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
// Import Scaffold
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
// Import Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
// Import komponen UI. Pastikan ini benar.
import com.example.shoppinglist.component.ItemInput
import com.example.shoppinglist.component.SearchInput
import com.example.shoppinglist.component.Title
import com.example.shoppinglist.components.ShoppingList
import com.example.shoppinglist.ui.theme.ShoppingListTheme
// Import komponen Bottom Bar dan Screen yang baru ditambahkan
import com.example.shoppinglist.component.BottomNavBar
import com.example.shoppinglist.component.BottomNavItem
import com.example.shoppinglist.component.ProfileScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingListTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen() // Panggil MainScreen untuk Navigasi
                }
            }
        }
    }
}

// Fungsi utama yang mengatur navigasi Bottom Bar
@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavBar(navController = navController) }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = BottomNavItem.Home.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            // Rute Home: Konten Shopping List yang sudah ada
            composable(BottomNavItem.Home.route) {
                HomeScreen()
            }
            // Rute Profile: Konten Nama dan NIM
            composable(BottomNavItem.Profile.route) {
                ProfileScreen()
            }
        }
    }
}


// Ubah fungsi ShoppingList() yang lama menjadi HomeScreen()
@Composable
fun HomeScreen() {
    var newItemText by rememberSaveable { mutableStateOf("") }
    var searchQuery by rememberSaveable { mutableStateOf("") }
    val shoppingItems = remember { mutableStateListOf<String>() }
    val filteredItems by remember(searchQuery, shoppingItems) {
        derivedStateOf {
            if (searchQuery.isBlank()) {
                shoppingItems
            } else {
                shoppingItems.filter { it.contains(searchQuery, ignoreCase = true) }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.safeDrawing.asPaddingValues())
            .padding(horizontal = 16.dp)
    )
    {
        Title()
        ItemInput(
            text = newItemText,
            onTextChange = { newItemText = it },
            onAddItem = {
                if (newItemText.isNotBlank()) {
                    shoppingItems.add(newItemText)
                    newItemText = ""
                }
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        SearchInput(
            query = searchQuery,
            onQueryChange = { searchQuery = it }
        )
        Spacer(modifier = Modifier.height(16.dp))
        ShoppingList(items = filteredItems)
    }
}