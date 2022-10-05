package com.lihan.bananacompany.data.local

import android.nfc.Tag
import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken
import com.lihan.bananacompany.data.util.JsonParser
import com.lihan.bananacompany.domain.model.Friend

@ProvidedTypeConverter
class Converters(
    private val jsonParser: JsonParser
) {

    @TypeConverter
    fun fromFriendsJson(json : String) : List<Friend>{
        return jsonParser.fromJson<List<Friend>>(
            json,
            object : TypeToken<List<Friend>>(){}.type)
            ?: emptyList()
    }

    @TypeConverter
    fun toFriendsJson(friends: List<Friend>) : String{
        return jsonParser.toJson(
            friends,
            object : TypeToken<ArrayList<Friend>>(){}.type
        )?:"[]"
    }

    @TypeConverter
    fun fromTagsJson(json : String) : List<String> {
        return jsonParser.fromJson<List<String>>(
            json,
            object : TypeToken<ArrayList<String>>(){}.type
        )?: emptyList()
    }

    @TypeConverter
    fun toTagsJson(tags : List<String>) : String{
        return jsonParser.toJson(
            tags,
            object  : TypeToken<ArrayList<String>>(){}.type
        )?:"[]"
    }

}