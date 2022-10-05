package com.lihan.bananacompany.data.remote.dto

import android.os.Parcelable
import com.lihan.bananacompany.data.local.entity.EmployeeEntity
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class EmployeeDto(
    val _id: String,
    val about: String,
    val address: String,
    val age: Int,
    val balance: String,
    val company: String,
    val email: String,
    val eyeColor: String,
    val favoriteFruit: String,
    val friends: List<FriendDto>,
    val gender: String,
    val greeting: String,
    val guid: String,
    val index: Int,
    val isActive: Boolean,
    val latitude: Double,
    val longitude: Double,
    val name: String,
    val phone: String,
    val picture: String,
    val registered: String,
    val tags: List<String>
) : Parcelable{

    fun toEmployeeEntity() : EmployeeEntity {
        return EmployeeEntity(
            _id,
            about,
            address,
            age ,
            balance,
            company,
            email,
            eyeColor,
            favoriteFruit,
            friends.map { it.toFried() },
            gender,
            greeting,
            guid,
            index,
            isActive,
            latitude,
            longitude,
            name,
            phone,
            picture,
            registered,
            tags,
        )
    }

}