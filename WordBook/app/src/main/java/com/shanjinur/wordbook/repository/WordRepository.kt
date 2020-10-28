package com.shanjinur.wordbook.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.shanjinur.wordbook.dao.WordDao
import com.shanjinur.wordbook.model.Word
import com.shanjinur.wordbook.room_db.WordRoomDatabase


class WordRepository(application: Application) {
    private var mWordDao: WordDao? = null
    private var mAllWords: LiveData<List<Word>>? = null

    init {
        val db = WordRoomDatabase.getDatabase(application)
        mWordDao = db!!.wordDao()
        mAllWords = mWordDao!!.getAllWords()
    }

    fun getAllWords(): LiveData<List<Word>>? {
        return mAllWords
    }

    fun insert(word: Word) {
        // had to use async task to insert in background
        mWordDao!!.insert(word)
    }
}