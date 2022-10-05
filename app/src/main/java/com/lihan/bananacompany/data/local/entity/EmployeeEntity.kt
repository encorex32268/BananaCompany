package com.lihan.bananacompany.data.local.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.lihan.bananacompany.domain.model.Employee
import com.lihan.bananacompany.domain.model.Friend
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable


@Entity
@Serializable
@Parcelize
data class EmployeeEntity(
    @PrimaryKey val _id: String,
    val about: String,
    val address: String,
    val age: Int,
    val balance: String,
    val company: String,
    val email: String,
    val eyeColor: String,
    val favoriteFruit: String,
    val friends: List<Friend>,
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

    fun toEmployee() : Employee {
        return Employee(
            _id,
            about,
            address,
            age ,
            balance,
            company,
            email,
            eyeColor,
            favoriteFruit,
            friends,
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