package com.example.shoppinglist.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.layout.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun Title() {
    Text(
        text = "Shopping List",
        style = MaterialTheme.typography.headlineLarge.copy(
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            color = MaterialTheme.colorScheme.primary
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        textAlign = TextAlign.Center
    )
}