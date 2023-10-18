package com.example.data.room

import androidx.room.TypeConverter
import com.example.domain.model.Owner
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RoomTypeConverter {

    @TypeConverter
    fun ownerToString(owner: Owner): String {
        return Gson().toJson(owner)
    }

    @TypeConverter
    fun stringToOwner(string: String): Owner {
        return Gson().fromJson(string, Owner::class.java)
    }
}

class ListOfStringToStringTypeConverter {

    @TypeConverter
    fun listOfStringToString(str: List<String>): String {
        return Gson().toJson(str)
    }

    @TypeConverter
    fun strToListString(str: String): List<String> {
        return Gson().fromJson(str, object : TypeToken<List<String>>() {}.type)
    }
}