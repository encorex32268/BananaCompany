package com.lihan.bananacompany.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class Employee(
    val _id: String,
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
) : Parcelable