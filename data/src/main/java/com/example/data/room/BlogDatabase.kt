package com.example.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.domain.model.Blog

@Database(entities = [Blog::class, BlogKey::class], version = 1, exportSchema = false)
@TypeConverters(RoomTypeConverter::class, ListOfStringToStringTypeConverter::class)
abstract class BlogDatabase : RoomDatabase() {
    companion object {
        fun getInstance(context: Context): BlogDatabase {
            return Room.databaseBuilder(
                context,
                BlogDatabase::class.java, name = "blog"
            ).build()
        }
    }

    abstract fun getBlogDAO(): BlogDAO
}