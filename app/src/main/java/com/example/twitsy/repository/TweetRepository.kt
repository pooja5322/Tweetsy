package com.example.twitsy.repository

import com.example.twitsy.api.TweetsyApi
import com.example.twitsy.models.TweetListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweetRepository @Inject constructor(private val api: TweetsyApi) {
    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories: StateFlow<List<String>>
        get() = _categories

    private val _categoriesTweets = MutableStateFlow<List<TweetListItem>>(emptyList())
    val categoriesTweets: StateFlow<List<TweetListItem>>
        get() = _categoriesTweets

    suspend fun getCategories() {
        val response = api.getCategory()
        if (response.isSuccessful && response.body() != null) {
            _categories.emit(response.body()!!)
        }
    }

    suspend fun getCategoriesTweets(category:String) {
        val response = api.getTweetsy("tweets[?(@.category==\"$category\")]")
        if (response.isSuccessful && response.body() != null) {
            _categoriesTweets.emit(response.body()!!)
        }
    }

}