package com.example.twitsy.Screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.twitsy.models.TweetListItem
import com.example.twitsy.viewmodels.DetailsViewModel

@Composable
fun Detailscreen() {
    val detailsViewModel: DetailsViewModel = hiltViewModel()
    val categories: State<List<TweetListItem>> = detailsViewModel.categories.collectAsState()
    LazyColumn(content = {
        items(categories.value) {
            TweetListItemData(tweet = it.text)
        }
    })
}

@Composable
fun TweetListItemData(tweet: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp), border = BorderStroke(1.dp, color = Color.Cyan)
    ) {
        Text(text = tweet, color = Color.Black, modifier = Modifier.padding(15.dp))
    }
}
