package com.shanjinur.wordbook.room_db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.shanjinur.wordbook.dao.WordDao
import com.shanjinur.wordbook.model.Word


@Database(entities = [Word::class], version = 1)
abstract class WordRoomDatabase: RoomDatabase() {
    abstract fun wordDao(): WordDao

    companion object{
        private var INSTANCE: WordRoomDatabase? = null

        fun getDatabase(context: Context?): WordRoomDatabase? {
            if (INSTANCE == null) {
                synchronized(WordRoomDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context!!.applicationContext,
                            WordRoomDatabase::class.java, "word_database"
                        )
                            .fallbackToDestructiveMigration()
                            .build()
                    }
                }
            }
            return INSTANCE
        }
    }
}