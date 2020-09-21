package com.omi.demograph.home.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
data class Downloads(
    val month_wise: MonthWise,
    val total: Int
):Parcelable