package com.lihan.bananacompany.domain.model

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class FriendConverter {

    @TypeConverter
    fun fromFriend(friends: List<Friend>) : String {
        return Gson().toJson(friends)
    }

    @TypeConverter
    fun toFriendList(string: String) : List<Friend>{
        val type = object : TypeToken<List<Friend>>(){}.type;
        return Gson().fromJson<List<Friend>>(string,type)
    }
}