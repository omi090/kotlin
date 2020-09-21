package com.omi.demograph.home.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
data class Data(
    val downloads: Downloads
):Parcelable