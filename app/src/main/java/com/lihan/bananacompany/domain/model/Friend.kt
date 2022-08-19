package com.lihan.bananacompany.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable


@Serializable
@Parcelize
data class Friend(
    val id: Int,
    val name: String
) : Parcelable