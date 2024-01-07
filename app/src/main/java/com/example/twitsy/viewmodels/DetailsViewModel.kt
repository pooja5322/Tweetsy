package com.example.twitsy.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.twitsy.models.TweetListItem
import com.example.twitsy.repository.TweetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DetailsViewModel@Inject constructor(private val repository: TweetRepository,private val savedStateHandle:SavedStateHandle) : ViewModel() {
    val categories : StateFlow<List<TweetListItem>>
        get() = repository.categoriesTweets

    init {
        viewModelScope.launch {
            val category = savedStateHandle.get<String>("category")?:"motivation"
            repository.getCategoriesTweets("Motivation")
        }
    }
}