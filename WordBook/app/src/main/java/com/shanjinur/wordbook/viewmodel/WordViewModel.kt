package com.shanjinur.wordbook.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.shanjinur.wordbook.model.Word
import com.shanjinur.wordbook.repository.WordRepository


class WordViewModel(application: Application) :
    AndroidViewModel(application) {
    private val mRepository: WordRepository = WordRepository(application!!)
    private val allWords: LiveData<List<Word>>?

    fun insert(word: Word?) {
        mRepository.insert(word!!)
    }

    init {
        allWords = mRepository.getAllWords()
    }
}