package com.lihan.bananacompany.domain.model

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TagsConverter {

    @TypeConverter
    fun fromTags(tags : List<String>) : String {
        return Gson().toJson(tags)
    }

    @TypeConverter
    fun toTags(string: String) : List<String>{
        val type = object : TypeToken<List<String>>(){}.type
        return Gson().fromJson(string,type)
    }
}