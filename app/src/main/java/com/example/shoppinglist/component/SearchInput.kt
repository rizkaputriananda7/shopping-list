package com.example.shoppinglist.component

// ... (semua import yang sudah ada)
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

// PASTIKAN IMPORT INI ADA UNTUK PROFILE SCREEN
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.Image
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.foundation.shape.CircleShape

// [Kode fungsi SearchInput() yang sudah ada]
@Composable
fun SearchInput(query: String, onQueryChange: (String) -> Unit) {
    OutlinedTextField(
        value = query,
        onValueChange = onQueryChange,
        label = { Text("Search items") },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription
            = "Search Icon")
        }
    )
}

@Preview(showBackground = true)
@Composable
fun SearchInputPreview() {
    // Call the actual SearchInput composable with sample values
    SearchInput(
        query = "Sample Search",
        onQueryChange = {} // An empty lambda can be used here
    )
}

// [Kode fungsi ProfileScreen() yang baru]
@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(0.8f),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(32.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Placeholder Foto (Menggunakan ikon Person)
                Image(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Profile Photo",
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary),
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .padding(8.dp)
                )
                Spacer(modifier = Modifier.height(24.dp))

                // Nama
                Text(
                    text = "Rizka Putri Ananda",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Spacer(modifier = Modifier.height(8.dp))

                // NIM
                Text(
                    text = "NIM: 2311522036",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }
    }
}