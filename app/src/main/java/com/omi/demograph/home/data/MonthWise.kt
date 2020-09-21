package com.omi.demograph.home.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
data class MonthWise(
    val apr: Int,
    val feb: Int,
    val jan: Int,
    val jun: Int,
    val mar: Int,
    val may: Int
):Parcelable