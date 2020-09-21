package com.omi.demograph.home.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GraphResponse(
    val apps: List<App>
):Parcelable