package com.example.android.guesstheword.screens.score

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel(finalScore: Int): ViewModel() {

    private val _finalScore = MutableLiveData<Int>(finalScore)
    val finalScore: LiveData<Int>
        get() = _finalScore

    private val _playAgainEvent = MutableLiveData<Boolean>(false)
    val playAgainEvent: LiveData<Boolean>
        get() = _playAgainEvent

    init {
        Log.i("ScoreViewModel", "finalScore = $finalScore")
    }

    fun onPlayAgain() {
        _playAgainEvent.value = true
    }

    fun onPlayAgainComplete() {
        _playAgainEvent.value = false
    }

}