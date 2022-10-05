package com.lihan.bananacompany.data.remote.dto

import android.os.Parcelable
import com.lihan.bananacompany.domain.model.Friend
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable


@Serializable
@Parcelize
data class FriendDto(
    val id: Int,
    val name: String
) : Parcelable{

    fun toFried() : Friend{
        return Friend(
            id = id,
            name = name
        )
    }
}